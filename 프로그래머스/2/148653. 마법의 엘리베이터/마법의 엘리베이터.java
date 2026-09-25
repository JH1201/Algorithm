import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        
        while(storey != 0) {
            
            int n = storey%10;
            storey = storey/10;
            
            //System.out.print("storey: " + storey + ", n: " + n);
            
            if(n > 5) {
                answer += 10 - n;
                storey += 1;
            }
            
            else if(n == 5) {
                answer += 5;
                if(storey%10 >= 5) storey += 1;
            }
            
            else {
                answer += n;
            } 
            
            //System.out.println(", answer: " +  answer);
        }
        
        
        return answer;
    }
}