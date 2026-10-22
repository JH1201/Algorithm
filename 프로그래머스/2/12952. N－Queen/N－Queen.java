import java.util.*;

class Solution {
    
    boolean[][] v;      // Q 모든 경로 체크 맵 
    
    public int solution(int n) {
        int answer = 0;
        
        boolean[][] map = new boolean[n][n];  // Q가 놓여진 맵
        v = new boolean[n][n];
        
        answer = dfs(map, 0, n);
        
        return answer;
    }
    
    public int dfs(boolean[][] map, int cnt, int n) {
        
        if(cnt == n) return 1;
        
        int res = 0;
        
        for(int i=0; i<map.length; i++) {
            
            if(i == cnt) {
                for(int j=0; j<map[i].length; j++) {
                    if(map[i][j] || v[i][j]) continue;
                    
                    // 현재 Q에서 갈 수 있는 모든 곳 true 
                    map[i][j] = true;
                    visited(i, j);
                    
                    
                    res += dfs(map, cnt+1, n);
                    
                    // 갈 수 있는 곳 false
                    map[i][j] = false;
                    undo(map);
                    
                }
            }
        }
        
        return res;
    }
    
    public void visited(int i, int j) {
        // 세로
        for(int a=0; a<v.length; a++) {
            v[a][j] = true;
        }
        
        // 가로
        for(int b=0; b<v[i].length; b++) {
            v[i][b] = true;
        }
        
        // 대각
        for(int a=0; a<v.length; a++) {
            for(int b=0; b<v[a].length; b++) {
                if(Math.abs(a-i) == Math.abs(b-j)) {
                    v[a][b] = true;
                }
            }
        }
    }
    
    public void undo(boolean[][] m) {
        for(int a=0; a<v.length; a++) {
            for(int b=0; b<v[a].length; b++) {
                v[a][b] = false;
            }
        }
        
        for(int a=0; a<v.length; a++) {
            for(int b=0; b<v[a].length; b++) {
                if(m[a][b]) visited(a, b);
            }
        }
        
    }
    
}