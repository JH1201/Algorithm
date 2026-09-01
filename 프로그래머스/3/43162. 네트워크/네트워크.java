import java.util.*;

class Solution {
    
    static boolean[] visited;
    int answer = 0;
    
    public int solution(int n, int[][] computers) {
        
        
        visited = new boolean[computers.length];
        
        for(int i=0; i<computers.length; i++) {
            if(!visited[i]) answer++;
            dfs(computers, i);
        }

        //if(answer > computers.length) answer -= 1;
        
        return answer;
    }

    public void dfs(int[][] computers, int idx) {
        if(visited[idx]) return;
        
        // 방문 처리
        visited[idx] = true;
        
        int cnt = 0;
        for(int i=0; i<computers.length; i++) {
            if(i == idx) continue;
            
            if(computers[i][idx] == 1) {
                dfs(computers, i);
                //cnt++;
            }
        }
        
        //if(cnt == 0) answer++;
        
    }
    
}