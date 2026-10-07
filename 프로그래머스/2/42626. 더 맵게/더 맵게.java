import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> {
            return a - b;
        });
        
        for(int i : scoville) {
            pQ.add(i);
        }
        
        int cnt = 0;
        while(!pQ.isEmpty()) {
            
            if(pQ.size() == 1) {
                if(pQ.peek() >= K) return answer; 
                else return -1;
            }
            
            else if(pQ.peek() < K) {
                int a = pQ.poll();
                int b = pQ.poll();
                int tmp = a + 2 * b;
                answer++;
                pQ.add(tmp);
            }
            
            else {
                break;
            }
        }
        
        
        return answer;
    }
    
}