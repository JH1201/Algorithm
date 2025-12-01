import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int N = prices.length;
        int[] answer = new int[N];
        
        for(int j=0; j<prices.length; j++) {
            int cnt = 0;
            
            for(int i=j+1; i<prices.length; i++) {
                cnt += 1;
                if(prices[i] < prices[j]) {
                    break;
                }
            }
            answer[j] = cnt;
        }
        
        
        return answer;
    }
}