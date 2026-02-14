import java.util.*;

class Solution {
    public  long solution(int n, int[] times) {
        long max = 0;
        
        for(int i=0; i<times.length; i++) {
            if(max < times[i]) max = times[i];
        }
        
        System.out.println("[max = " + max + "]");
        
        long start = 1;
        long end = (long)n * max;
        long answer = end;
        
        while(start <= end) {
            System.out.println("start = " + start);
            System.out.println("end = " + end);
            
            long mid = (start+end)/2;
            System.out.println("mid = " + mid);
            
            long num = 0;
            
            for(int j=0; j<times.length; j++) {
                num += mid/times[j];
            }
            System.out.println("num = " + num);
            
            if(num < n) {
                start = mid+1;
                
            }
            else {
                answer = mid;
                end = mid-1;
            }
            
            System.out.println("answer = " + answer);
            
            System.out.println("------------------------- ");
            
        }
        

        return answer;
    }
}