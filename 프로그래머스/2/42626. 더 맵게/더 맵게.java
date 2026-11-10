import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
      
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        
        for(int i :scoville) {
            pQ.offer(i);
        }
        
        
        while(!pQ.isEmpty() && pQ.peek() < K) {
            int fir = pQ.poll();
            int newScobill = 0;
            
            if(pQ.isEmpty()) {
                if(fir < K) return -1;
            }
            else {
                int sec = pQ.poll();
                newScobill = fir + 2 * sec;
                pQ.offer(newScobill);
                answer++;
            }
        }
        
        return answer;
    }
    
}