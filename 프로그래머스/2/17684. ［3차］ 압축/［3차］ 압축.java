import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<26; i++) {
            char c = (char)('A' + i);
            map.put(String.valueOf(c), i+1);
        }
        
        StringBuilder sb = new StringBuilder();
        String prevStr = "";
        for(int i=0; i<msg.length(); i++) {
            char c = msg.charAt(i);
            
            sb.append(c);
            String curStr = sb.toString();
            
            if(map.get(curStr) != null) {
                prevStr = curStr;
            }
            else {
                list.add(map.get(prevStr));
                map.put(curStr, map.size()+1);
                
                sb.setLength(0);
                
                sb.append(c);
                prevStr = sb.toString();
            }
        }
        
        list.add(map.get(sb.toString()));
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}