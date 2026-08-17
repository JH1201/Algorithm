import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long answer = 0;
        long max = 0;
        
        // 가장 오래 걸리는 시간
        for(int t : times) {
            if(max < t) max = t;
        }
        
        // 통과하는데 가장 오래 걸리는 시간
        long end = max * n;
      
        // 통과하는데 가장 짧게 걸리는 시간
        long start = 1;
        
        System.out.println("end = " + end);
        
        while(start <= end) {
            
            long mid = (start + end) / 2;
            long num = 0;
            
            for(int t : times) {
                num += mid/t;
            }
            
            if(num < n) start = mid + 1;
            else {
                end = mid - 1;
                
                // 이후에 더 적은 시간이 걸리는 상황이 있을 수 있음
                answer = mid;
            }
        }
        
        return answer;
    }
}