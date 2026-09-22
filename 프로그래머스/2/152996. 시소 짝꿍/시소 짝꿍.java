import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<weights.length; i++) {
            if(map.get(weights[i]) == null) map.put(weights[i], 1);
            else map.put(weights[i], map.get(weights[i])+1);
            
        }
        
        Arrays.sort(weights);
        
        for(int key : weights) {
            
            if(map.get(key) > 1) {
                map.put(key, map.get(key)-1);
            }
            else {
                map.remove(key);
                
            }
            
            int twoKey = key*2;
            int threeKey = 0;
            int fourKey = 0; 
            
            if(key*3%2 == 0) threeKey = key*3/2;
            if(key*4%3 == 0) fourKey = key*4/3;
            
            //System.out.println("key: " + key + " / twoKey: " + twoKey + ", threeKey: " + threeKey + ", fourKey: " + fourKey);

            // 같은 몸무게
            if(map.containsKey(key)) {
                answer += map.get(key);
            }
            
            // 1 : 2
            if(map.containsKey(twoKey)) {
                answer += map.get(twoKey);
            }
            
            // 2 : 3
            if(threeKey != 0 && map.containsKey(threeKey)) {
                answer += map.get(threeKey);
            }
            
            // 3 : 4
            if(fourKey != 0 && map.containsKey(fourKey)) {
                answer += map.get(fourKey);
            }
        
        }
        
        return answer;
    }
}