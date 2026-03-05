import java.util.*;

class Solution {
    public  long solution(int n, int[] times) {
        
        long max = 0;
        long answer = 0;
        
        for(int i=0; i<times.length; i++) {
            if(max < times[i]) max = times[i];
        }
        
        long start = 1;
        long end = (long)n * max;
        
        while(start <= end) {
            
            long mid = (start + end) / 2;
            long num = 0;
            
            // 걸리는 시간동안 처리할 수 있는 인원 수
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