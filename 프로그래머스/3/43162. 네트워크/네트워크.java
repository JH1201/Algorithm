import java.util.*;

class Solution {
    
    boolean[] v;
    int answer = 0;
    
    public int solution(int n, int[][] computers) {
        
        v = new boolean[n];
        
        for(int i=0; i<computers.length; i++) {
            if(!v[i]) answer++;
            dfs(computers, i);
        }
        
    
        return answer;
    }

    public void dfs(int[][] computers, int idx) {
        
        if(v[idx]) return;
        v[idx] = true;
        
        // 노드로 부터 갈 수 있는 노드 찾기
        for(int i=0; i<computers.length; i++) {
            if(i == idx) continue;
            
            if(computers[i][idx] == 1) {
                dfs(computers, i);
            }

        }
        
    }
    
}