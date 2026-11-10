import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        HashSet<String> assort = new HashSet<>();
        
        for(int i=0; i<clothes.length; i++) {
            ArrayList<String> list = map.getOrDefault(clothes[i][1], new ArrayList<>());
            list.add(clothes[i][0]);
            
            map.put(clothes[i][1], list);
            assort.add(clothes[i][1]);
        }
        
        int sum = 1;
        
        for(String key : assort) {
            sum *= (map.get(key).size() + 1);
        }
        
        answer = sum - 1;

        return answer;
        
    }
}