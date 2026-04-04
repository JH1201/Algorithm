import java.util.*;

class Solution {
    public  long solution(int n, int[] times) {
        
        long max = 0;
        long answer = 0;
        
        // 가장 오래 걸리는 시간
        for(int i=0; i<times.length; i++) {
            if(max < times[i]) max = times[i];
        }
        
        // 가장 짧게 통과 
        long start = 1;
        
        // 통과하는데 가장 긴 시간
        long end = max * (long)n;
        
        while(start <= end) {
            
            long mid = (start+end) / 2;
            long num = 0;
            
            for(int i=0; i<times.length; i++) {
                num += mid/times[i];
            }
            
            if(num < n) start = mid+1;
            else {
                end = mid-1;
                answer = mid;
            }
            
            
        }
     
        return answer;
    }
}