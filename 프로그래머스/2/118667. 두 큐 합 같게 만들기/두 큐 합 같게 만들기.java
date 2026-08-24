import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        
        long q1Sum = 0;
        long totalSum = 0;
        for(int i=0; i<queue1.length; i++) {
            
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            
            q1Sum += queue1[i];
            totalSum += queue1[i] + queue2[i];
        }
        
        if(totalSum % 2 == 1) return -1;
        long target = totalSum/2;
        
        while(true) {
            if(target == q1Sum) break;
            
            if(answer>(queue1.length+queue2.length)*2) return -1;
            
            else if(target > q1Sum) {
                q1Sum += q2.peek();
                q1.add(q2.poll());
            }
            else {
                q1Sum -= q1.peek();
                q2.add(q1.poll());
            }
            
            answer++;
        }
        
        
        return answer;
    }
}