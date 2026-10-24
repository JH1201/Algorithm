import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        
        char[] arr = number.toCharArray();
        int cnt = k;
        
        for(int i=0; i<arr.length; i++) {
            
             while(!stack.isEmpty() && stack.peek() < arr[i] -'0' && cnt > 0) {
                stack.pop();
                cnt--;
            }
            stack.push(arr[i] -'0');
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        answer = sb.reverse().toString().substring(0, number.length()-k);
                
        return answer;
    }
    
}