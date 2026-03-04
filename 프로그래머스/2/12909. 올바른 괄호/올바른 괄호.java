import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<String> stack = new Stack<>();
            
        
        for(int i=0; i<s.length(); i++) {
            
            String v = String.valueOf(s.charAt(i));
            
            if(stack.isEmpty()) stack.push(v);
            else {
                String t = stack.peek();
                if(t.equals(v)) stack.push(v);
                else {
                    if(stack.peek().equals("(")) stack.pop();
                    else stack.push(v);
                }
            }
        }
        
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}