import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public ArrayList solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            if(map.get(s.charAt(i)) == null) 
            {
                map.put(s.charAt(i), i);
                answer.add(-1);
            }
            else 
            {
                int res = i - map.get(s.charAt(i));
                answer.add(res);
                map.put(s.charAt(i), i);
            }
            
        }
        
        return answer;
    }
}