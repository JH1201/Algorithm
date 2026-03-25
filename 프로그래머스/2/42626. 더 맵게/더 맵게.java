import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        //Arrays.sort(scoville);
        
        for(int i : scoville) q.add(i);
        
        while(q.size() >= 2) {
            if(q.peek() < K) {
                int fir_min = q.poll();
                int sec_min = q.poll();

                int scob = getScobill(fir_min, sec_min);
                q.add(scob);
                answer++;
            }
            else {
                break;
            }
        }
        
        if(q.peek() < K) answer = -1;

        return answer;
    }
    
    public int getScobill(int a, int b) {
        return a + (b*2);
    }
}