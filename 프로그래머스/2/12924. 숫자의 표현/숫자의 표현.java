import java.util.*;

class Solution {
    
    boolean[] v;
    
    public int solution(int n) {
        int answer = 0;
        
        v = new boolean[n+1];
        
        for(int i=1; i<=n; i++) {
            answer += dfs(i, n);
        }
        
        
        return answer;
    }
    
    public int dfs(int start, int n) {
        if(start == n) return 1;
        
        int sum = 0;
        for(int i=start; i<=n; i++) {
            
            if(sum == n) return 1;
            else if(sum > n) return 0;
            
            sum += i;
        }
        
        return 0;
        
    }
    
}