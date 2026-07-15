import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++) {
            int tmp = tangerine[i];
            if(map.get(tmp) == null) {
                map.put(tmp, 1);
            }
            else {
                map.put(tmp, map.get(tmp)+1);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        /*
        for(int cnt : list) { 
            System.out.println(cnt);   
        }
        */
        
        for(int cnt : list) {
            k -= cnt;
            answer++;
            if(k <= 0) {
                break;
            }
       
        }
        
        return answer;
    }
}