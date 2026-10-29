import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int n, int[] money) {
        
        //dfs(0, n, money, 0);
        
        //dp[i] == i원을 만드는 방법의 수
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for(int m : money) {
            for(int i=m; i<=n; i++) {
                dp[i] = ( dp[i] + dp[i-m]) % 1000000007;
            }
        }
        
        answer = dp[n];
        
        return answer;
    }
    
    /*
    public void dfs(int idx, int n, int[] money, int sum) {
        
        if(sum == n) {
            answer = (answer + 1) % 1000000007;
            return ;
        }
        
        if(sum > n) return;
        if(idx >= money.length) return;
        
        dfs(idx, n, money, sum + money[idx]);
        dfs(idx + 1, n, money, sum);
        
    }
    */
    
}