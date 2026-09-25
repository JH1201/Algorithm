import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        int answer = 0;
        
        int[] times = new int[1450];
        
        for(int i=0; i<book_time.length; i++) {
            int startTime = getMin(book_time[i][0]);
            int endTime = getMin(book_time[i][1]) + 10;
            
            for(int j=startTime; j<endTime; j++) {
                times[j] += 1;
            }
        }
        
        for(int i=0; i<times.length; i++) {
            answer = Math.max(answer, times[i]);
        }
        
        return answer;
    }
    
    public int getMin(String str) {
        String[] t = str.split(":");
        
        int hours = Integer.valueOf(t[0]) * 60;
        int min = Integer.valueOf(t[1]);
        
        return hours + min;
    }
}
