import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, ArrayList<String>> s = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            
            ArrayList<String> list = s.getOrDefault(clothes[i][1], new ArrayList<>(Arrays.asList("")));
                
            list.add(clothes[i][0]);
            s.put(clothes[i][1], list);
            
        }
        
        for(Map.Entry<String, ArrayList<String>> entry : s.entrySet()) {
            ArrayList<String> arr = entry.getValue();
            
            System.out.println(entry.getKey() + ", " + s.get(entry.getKey()).size());
            
            answer *= arr.size();
        }

        return answer-1;

    }
}