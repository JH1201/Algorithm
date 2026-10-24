import java.util.*;

class Solution {
    
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0 ;
        
        for(int i=0; i<n; i++) {
            int t = map.getOrDefault(i, 1);
            map.put(i, t);
        }
        
        for(int i=0; i<reserve.length; i++) {
            
            int t = map.getOrDefault(reserve[i]-1, 1);
            
            map.put(reserve[i]-1, t+1);
        }
        
        for(int i=0; i<lost.length; i++) {
            
            int t = map.getOrDefault(lost[i]-1, 1);
            
            map.put(lost[i]-1, t-1);
        }
        
        for(int i=0; i<n; i++) {
            
            if(map.get(i) >= 1) continue;
            else {
                check(map, i, n);
            }
        }
        
        for(int i=0; i<n; i++) {
            
            if(map.get(i) >= 1) answer++;
        }
       
        return answer;
    }
    
    public void check(HashMap<Integer, Integer> map, int per, int n) {
        if(per == 0) {
            if(map.get(per+1) > 1){
                map.put(per+1, map.get(per+1)-1);
                map.put(per, 1);
                return;
            }
        }
        else if(per == n-1) {
            if(map.get(per-1) > 1) {
                map.put(per-1, map.get(per-1)-1);
                map.put(per, 1);
                return;
            }
        }
        
        else {
            if(map.get(per-1) > 1) {
                map.put(per-1, map.get(per-1)-1);
                map.put(per, 1);
                return;
            }
            else if(map.get(per+1) > 1){
                map.put(per+1, map.get(per+1)-1);
                map.put(per, 1);
                return;
            }
        }
    }
}