import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Deque<Character> deque = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++) {
            deque.offerLast(s.charAt(i));
        }
        
        for(int i=0; i<s.length(); i++) {
            String tmpArr = "";
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<deque.size(); j++) {
                char c = deque.pollFirst();
                sb.append(c);
                deque.offerLast(c);
            }
            
            boolean flag = checkRightStr(sb.toString());
            
            if(flag) answer++;
            
            deque.offerLast(deque.pollFirst());
        }
        
        
        
        return answer;
    }
    
    public boolean checkRightStr(String s) {
        boolean answer = true;
        
        Stack<String> stack = new Stack<>();
            
        
        for(int i=0; i<s.length(); i++) {
            
            String v = String.valueOf(s.charAt(i));
            
            if(stack.isEmpty()) stack.push(v);
            else {
                String t = stack.peek();
                if(t.equals(v)) stack.push(v);
                else {
                    if(v.equals(")")) {
                        if(stack.peek().equals("(")) stack.pop();
                    }
                    else if(v.equals("}")) {
                        if(stack.peek().equals("{")) stack.pop();
                    }
                    else if(v.equals("]")) {
                        if(stack.peek().equals("[")) stack.pop();
                    }
                    
                    else stack.push(v);
                }
            }
        }
        
        if(!stack.isEmpty()) answer = false;
        
        return answer;
    }
}