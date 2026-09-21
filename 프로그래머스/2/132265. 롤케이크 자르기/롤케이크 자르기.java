import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashSet<Integer> left = new HashSet<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        
        for(int i=0; i<topping.length; i++) {
            
            if(right.get(topping[i]) == null) {
                right.put(topping[i], 1);
                continue;
            }
            
            right.put(topping[i], right.get(topping[i])+1);
        }
        
        for(int i=0; i<topping.length; i++) {
            
            left.add(topping[i]);
            
            if(right.get(topping[i]) == 1) {
                right.remove(topping[i]);
            }
            else right.put(topping[i], right.get(topping[i])-1);
            
            
            
            if(left.size() == right.keySet().size()) answer++;
            
        }
        
        
        return answer;
    }
}