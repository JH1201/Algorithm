import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
      
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        
        for(int i : scoville) {
            pQ.offer(i);
        }
        
        while(!pQ.isEmpty()) {
            
            int curVal = pQ.poll();
            
            if(curVal >= K) break;
            
            else {
                
                if(pQ.isEmpty()) return -1;
                
                int newVal = curVal + (2 * pQ.poll());
                pQ.offer(newVal);
                answer += 1;
            }
            
        }
        
        return answer;
    }
    
}