import java.util.*;

class Solution {
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        int len = computers.length;
        
        visited = new boolean[n+1];
        
        for(int i=1; i<=len; i++) {
            if(!visited[i]) answer++;
            dfs(computers, i);
        }
        return answer;
    }
    
    public void dfs(int[][] computers, int idx) {
        
        if(visited[idx]) return;
        visited[idx] = true;
        
        //System.out.println("idx 노드: " + idx);
        
        // 갈 수 있는 노드 확인
        for(int i=1; i<=computers.length; i++) {
            
            if(i == idx) continue;
            if(computers[i-1][idx-1] == 1) dfs(computers, i);
        }
        
        
    }
    
}