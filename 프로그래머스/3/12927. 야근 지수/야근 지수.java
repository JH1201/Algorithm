import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        int sum = 0;
        for(int i : works) {
            sum += i;
        }
        
        if(sum <= n) return 0;
        
        // 피로도 = 남은 작업량^2
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        
        for(int i : works) {
            pQ.offer(i);
        }
        
        while(!pQ.isEmpty()) {
            
            if(n <= 0) break;
            
            int tmp = pQ.poll();
            pQ.offer(tmp-1);
            n--;
        }
        
        while(!pQ.isEmpty()) {
            int tmp = pQ.poll();
            answer += tmp * tmp;
        }
        
        return answer;
    }
    
}