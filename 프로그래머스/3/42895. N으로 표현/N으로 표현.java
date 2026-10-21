import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
    
        HashSet<Integer>[] dp = new HashSet[9];
        
        for(int i=1; i<=8; i++) {
            dp[i] = new HashSet<>();
        }
        
        for(int i=1; i<=8; i++) {
            
            String connectedNum = "";
            for(int j=0; j<i; j++) {
                connectedNum += String.valueOf(N);
            }
            
            dp[i].add(Integer.valueOf(connectedNum));
            
            for(int j=1; j<i; j++) {
                for(int a : dp[j]) {
                    for(int b : dp[i-j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        
                        if(b != 0) {
                            dp[i].add(a/b);
                        }
                    }
                }
            
            }
        }
        
        for(int i=1; i<dp.length; i++) {
            if(dp[i].contains(number)) {
                return i;
            }
        }
        
        
        return answer;
    }
}