
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int maxN = citations[citations.length-1];
        
        for(int i=0; i<=maxN; i++) {
            
            // i번 이상 인용된 수
            int upI = 0;
            
            // i번 이하 인용된 수
            int downI = 0;
            
            for(int cnt : citations) {
                if(cnt >= i) upI++;
            }
            
            for(int cnt : citations) {
                if(cnt <= i) downI++;
            }
            
            //System.out.println("i: " + i + ", upI: " + upI + ", downI:" + downI); 
            //System.out.println("=================="); 
            
            if(upI >= i) {
                if(answer < i) answer = i;
            }
        }
        
        return answer;
    }
}