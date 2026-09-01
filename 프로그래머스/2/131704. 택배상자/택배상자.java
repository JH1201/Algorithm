import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1; i<=order.length; i++) {
            q.add(i);
        }
        
        int t = 0;
        int targetNum = order[t];
        
        int check = 0;
        
        while(t < order.length) {
            
            if(q.isEmpty()) break;
            
            targetNum = order[t];
            
            if(!q.isEmpty()) {
                if(targetNum == q.peek()) {
                    answer++;
                    t += 1;
                    q.poll();
                }

                else if(targetNum != q.peek()) {
                    if(!s.isEmpty()) {
                        if(s.peek() == targetNum) {
                            answer++;
                            s.pop();
                            t += 1;
                            continue;
                        }
                        else {
                            s.push(q.poll());
                        }
                        continue;
                    }
                    s.push(q.poll());
                }
            }
            
        }
        
        while(!s.isEmpty()) {
            
            targetNum = order[t];
            //System.out.println("s.size() "+ s.size() + " peek : " + s.peek() + " target : " + targetNum + " t: " + t);
            
            if(s.peek() == targetNum) {
                s.pop();
                answer++;
                t += 1;
                if(t >= order.length) break;
                targetNum = order[t];
            }
            else {
                break;
            }
        }
        
        
        return answer;
    }
}