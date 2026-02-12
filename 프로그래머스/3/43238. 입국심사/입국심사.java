import java.util.*;

class Solution {
    public  long solution(int n, int[] times) {
        int max = Arrays.stream(times).max().getAsInt();

        long start = 1;
        long end = (long)max * n;
        long answer = end;

        while(start <= end) {
            long mid = (start + end) / 2;
            long num =0; // 심사관이 처리하는 사람수

            // 심사관이 처리하는 사람수
            for(int i=0; i<times.length; i++) {
                num += mid/times[i];
            }

            if(num < n) {
                start = mid + 1;

            } else {
                answer = mid;
                end = mid - 1;
            }
        }


        return answer;
    }
}