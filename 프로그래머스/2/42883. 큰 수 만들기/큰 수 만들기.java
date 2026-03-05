import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        Stack<Integer> stack = new Stack<>();
        
        int cnt = k;
        for(int i=0; i<number.length(); i++) {
            char s = number.charAt(i);
            int tmp = s - '0';
            
            while(!stack.isEmpty() && k > 0 && stack.peek() < tmp) {
                stack.pop();
                k--;
            }
            stack.push(tmp);
        }
        
        
        StringBuffer sb = new StringBuffer();
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    
        
        return sb.reverse().toString().substring(0, number.length()-cnt);
    }
}