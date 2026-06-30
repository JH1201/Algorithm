import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n+1];
        
        int len = computers.length;
        
        for(int i=1; i<=len; i++) {
            if(!visited[i]) answer++;
            dfs(computers, i);
        }

        return answer;
    }

    public void dfs(int[][] computers, int idx) {
        
        if(visited[idx]) return;
        visited[idx] = true;
        
        for(int i=1; i<=computers.length; i++) {
            if(i == idx) continue;
            if(computers[idx-1][i-1] == 1) dfs(computers, i);
        }
        
    }
    
}