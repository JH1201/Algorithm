import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String[] s : clothes) {
            if(map.get(s[1]) == null) {
                ArrayList<String> arr = new ArrayList<>();
                arr.add(s[0]);
                
                map.put(s[1], arr);
            }
            
            else {
                map.get(s[1]).add(s[0]);
            }
        }
        
        
        for(String key : map.keySet()) {
            
            //System.out.println(key + ", " + map.get(key).size());
            answer *= (map.get(key).size()+1);
        }

        return answer-1;
        
    }
}