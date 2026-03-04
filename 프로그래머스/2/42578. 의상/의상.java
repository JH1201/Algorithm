import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        
        for(int i=0; i<clothes.length; i++) {
            String category = clothes[i][1];
            ArrayList<String> list = map.getOrDefault(category, new ArrayList<>(Arrays.asList("0")));
            
            list.add(clothes[i][0]);
            
            map.put(category, list);
        }
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            ArrayList arr = entry.getValue();
            System.out.println(entry.getKey() + ", " + arr.size());
            answer *= arr.size();
        }
        
        return answer -1;
            
    }
}