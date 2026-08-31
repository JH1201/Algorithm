import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        List<Integer> list = new ArrayList<>();

        for (int num : prices) {
            list.add(num);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        
        for(int i=0; i<prices.length; i++) {
            
            int t = 0;
            
            for(int j=i+1; j<prices.length; j++) {
                if(prices[i] > prices[j]) {
                    t += 1;   
                    break;
                }
                
                t += 1;
            }
            
            answer.add(t);
        }
        
        int[] answerArr = new int[answer.size()];
        
        for(int i=0; i<answer.size(); i++) {
            answerArr[i] = answer.get(i);
        }
        
        return answerArr;
    }
}