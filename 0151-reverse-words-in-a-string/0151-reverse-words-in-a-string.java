import java.util.*;

class Solution {
    public String reverseWords(String s) {
        
        Stack<String> stack = new Stack<>();

        s = s.trim();
        System.out.println(s);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char tmp = s.charAt(i);

            if(tmp == ' ') {
                if(sb.length() == 0) continue;

                stack.push(sb.toString());
                sb.setLength(0);
                continue;
            }
            sb.append(tmp);
        }
        stack.push(sb.toString());

        StringBuilder sB = new StringBuilder();
        while(!stack.isEmpty()) {
            String st = stack.pop();
            if("".equals(st)) continue;
            else {
                sB.append(st);
                sB.append(" ");
            }
        }

        return sB.toString().trim();
    }
}