import java.util.*;

class Solution {
    
    boolean[][] v;
    boolean[][] vMap;
    
    public int solution(int n) {
        int answer = 0;
        
        int[][] map = new int[n][n];
        v = new boolean[n][n];
        vMap = new boolean[n][n];
        
        answer = dfs(n, map, 0);
        
        return answer;
    }
    
    public int dfs(int n, int[][] map, int cnt) {
        
        // cnt == 현재 놓인 Q의 갯수
        if(cnt == n) return 1;
        
        int res = 0;
        
        for(int i=0; i<map.length; i++) {
            
            if(i != cnt) continue;
            
            for(int j=0; j<map[i].length; j++) {
                
                if(vMap[i][j] || v[i][j]) continue;
                
                // 현재 Q가 놓여진 자리 기준으로 공격할 수 있는 곳에 방문 처리
                visited(i, j);
                vMap[i][j] = true;
                
                res += dfs(n, map, cnt + 1);
                
                // 현재 Q가 놓여진 자리 기준으로 공격할 수 있는 곳 방문 처리 해제
                vMap[i][j] = false;
                outVisited();
                
                
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
                
                if(Math.abs(a - i) == Math.abs(b - j)) {
                    v[a][b] = true;
                }
            }
        }
    }
    
    public void outVisited() {
        
        // 전체 공격 영역 초기화
        for(int a=0; a<v.length; a++) {
            for(int b=0; b<v[a].length; b++) {
                v[a][b] = false;
            }
        }

        // 아직 놓여 있는 Queen 기준으로 다시 공격 영역 설정
        for(int a=0; a<vMap.length; a++) {
            for(int b=0; b<vMap[a].length; b++) {

                if(vMap[a][b]) {
                    visited(a, b);
                }
            }
        }
    }
    
}