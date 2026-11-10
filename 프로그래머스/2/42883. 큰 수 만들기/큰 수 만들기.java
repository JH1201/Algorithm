import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        String answer = "";
        Stack<Character> s = new Stack<>();
        
        int cnt = k;
        
        for(int i=0; i<number.length(); i++) {
            
            int tmp = number.charAt(i) - '0';
            
            while(!s.isEmpty() && tmp > s.peek() - '0' && k > 0) {
                s.pop();
                k--;
            }
            if(s.size() < number.length() - cnt) s.push(number.charAt(i));
            else continue;
           
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        
        sb.reverse();
        
        answer = sb.toString();
        
        return answer;
    }
    
}