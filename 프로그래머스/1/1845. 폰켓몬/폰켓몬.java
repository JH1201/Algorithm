import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int max = nums.length /2;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) {
            if(map.get(i) == null) {
                map.put(i, 1);
            }
            else {
                int t = map.get(i) + 1;
                map.put(i, t);
            }
            
        }
        if(map.size() < max) answer = map.size();
        else answer = max;
        
        
        return answer;
    }
}