import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        int answer = 0;
        
        Stack<Integer> wQ = new Stack<>();
        
        int idx = 0;
        
        for(int i=0; i<order.length; i++) {
            int curBox = i+1;
            
            // 같다면 다음으로
            if(curBox == order[idx]) {
                answer++;
                idx++;
            }
            
            // 다르다면 대기에 있는지 확인하고 push
            else {
                
                if(wQ.isEmpty()) {
                    wQ.push(curBox);
                    continue;
                }
                
                while(!wQ.isEmpty() && idx < order.length) {
                    if(wQ.peek() == order[idx]) {
                        wQ.pop();
                        answer++;
                        idx++;
                    }
                    else {
                        break;
                    }
                }
                wQ.push(curBox);
            }
            
        }
        
        //System.out.println("size: " + wQ.size() + " / idx: " + idx);
        
        while(!wQ.isEmpty() && idx < order.length) {
            if(order[idx] == wQ.peek()) {
                wQ.pop();
                idx++;
                answer++;
            }
            else break;
        }
        
        return answer;
    }
}