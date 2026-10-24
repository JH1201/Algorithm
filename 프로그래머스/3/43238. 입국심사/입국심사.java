import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long answer = 0;
        
        int p = times.length; // 심사관 인원수
        if(p == 1) return (long)n * times[0];
        
        long max = 0;
        for(int i : times) {
            if(max < i) max = i;
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
            }
            else {
                end = mid - 1;
                answer = mid;
            }
            
        }
        
        
        return answer;
    }
}