import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        int answer = 0;
        
        Stack<Integer> waitS = new Stack<>();
        Stack<Integer> resultS = new Stack<>();
        
        boolean[] v = new boolean[order.length];
        
        // 4 3 1 2 5
        // 1 2 3 4 5
        
        int curBox = 1;
        
        for(int i=0; i<order.length; i++) {
            
            int wantedBox = order[i];
            
            if(!waitS.isEmpty() && waitS.peek() == wantedBox) {
                resultS.push(wantedBox);
                waitS.pop();
                continue;
            }
            
            while(curBox <= order.length && curBox <= wantedBox) {
                if(curBox == wantedBox) {
                    resultS.push(wantedBox);
                    curBox++;
                    break;
                }
                
                waitS.push(curBox);
                curBox++;
            }
            
            // 원하는 상자를 적재하지 못했다면 종료
            if(wantedBox != resultS.peek()) {
                break;
            }
        }
        answer = resultS.size();
        
        return answer;
    }
}