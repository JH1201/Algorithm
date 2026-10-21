import java.util.*;

class Solution {
    
    boolean[] v;
    
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        
        v = new boolean[dungeons.length];
        
        // 던전 배열, 깊이, 탐험 던전 갯수, 피로도
        answer = dfs(dungeons, 0, k);
        
        return answer;
    }
    
    public int dfs(int[][] dungeons, int cnt, int k) {
        
        int res = cnt;
        
        for(int i=0; i<dungeons.length; i++) {
            int minTired = dungeons[i][0];
            int useTired = dungeons[i][1];
            
            if(!v[i] && minTired <= k) {
                // 방문 처리
                v[i] = true;
                res = Math.max(res, dfs(dungeons, cnt+1, k-useTired));
                v[i] = false;
            }
        }
        return res;
        
    }
    
}