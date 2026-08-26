import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long answer = 0;
        long max = 0;
        
        for(int t : times) {
            if(max < t) max = t;
        }
            
        long start = 1;
        long end = max * n;
        
        while(start <= end) {
            long mid = (start + end) / 2;
            
            long num = 0;
            for(int i=0; i<times.length; i++) {
                num += mid/times[i];
            }
            
            if(num < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                
                answer = mid;
            }
        }
        
        return answer;
    }
}