import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
            
        HashMap<String, Integer> parti = new HashMap<>();
        
        int cnt = 1;
        for(String p : participant) {
            if(parti.get(p) == null) {
                parti.put(p, cnt);
            }
            else {
                int t = parti.get(p) + 1;
                parti.put(p, t);
            }
        }
        
        for(String c : completion) {
            int t = parti.get(c)-1;
            parti.put(c, t);
        }
        
        for(String p : participant) {
            if(parti.get(p) > 0){
                answer = p;
                break;
            }   
        }
         
        return answer;
    }
}