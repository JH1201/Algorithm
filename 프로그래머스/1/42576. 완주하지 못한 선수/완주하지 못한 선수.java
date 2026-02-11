import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<participant.length; i++) {
            if(map.get(participant[i]) != null) {
                if(map.get(participant[i]) >= 1) {
                    int tmp = map.get(participant[i]) + 1;
                    map.put(participant[i], tmp);
                    continue;
                }
            }
            
            map.put(participant[i], 1);
        }
        
        for(int j=0; j<completion.length; j++) {
            if(map.get(completion[j]) != null) {
                map.replace(completion[j], map.get(completion[j])-1);
            }
        }
        
        for(int i=0; i<participant.length; i++) {
            if(map.get(participant[i]) != 0 && map.get(participant[i]) > 0) {
                answer = participant[i];
                break;
            }
        }
         
        return answer;
    }
}