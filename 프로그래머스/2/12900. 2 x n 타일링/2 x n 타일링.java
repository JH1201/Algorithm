import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int n) {
        
        int a = 2;
        int b = 1;
        
        if(n <= 3) {
            return n;
        }
        
        for(int i=3; i<=n; i++) {
            answer = (a + b) % 1000000007;
            
            b = a;
            a = answer;
        }
       
        return answer;
    }

 
}