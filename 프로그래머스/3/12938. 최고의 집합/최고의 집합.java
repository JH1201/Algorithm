import java.util.*;

class Solution {
    
    
    public int[] solution(int n, int s) {
        
        
        if(n > s) {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        int[] answer = new int[n];
        
        int tmp = s/n;
        int mod = s%n;
        
        for(int i=0; i<n; i++) {
            answer[i] = tmp;
        }
        
        for(int i=n-mod; i<n; i++) {
            answer[i]++;
        }
        
        
        
        return answer;
    }
    
 
}