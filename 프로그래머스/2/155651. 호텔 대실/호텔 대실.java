import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[] room = new int[1451];
        
        //PriorityQueue<Node> pQ = new PriorityQueue<>();
        
        for(int i=0; i<book_time.length; i++) {
            int start_time = getMin(book_time[i][0]);
            int end_time = getMin(book_time[i][1]) + 10;
            
            for(int j=start_time; j<end_time; j++) {
                room[j]++;
            }
        }
        
        for(int i=0; i<=1450; i++) {
            answer = Math.max(answer, room[i]);
        }
        
        
        return answer;
    }
    
    public int getMin(String str) {
        String[] tmp = str.split(":");
        
        int h = Integer.valueOf(tmp[0]) * 60;
        int m = Integer.valueOf(tmp[1]);
        
        return h+m;
    }
    
}
