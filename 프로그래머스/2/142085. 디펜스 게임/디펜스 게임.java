import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        
        // 무적권의 수 >= enemy의 길이이면 answer = k
        if(k >= enemy.length) return enemy.length;
        
        
        for(int e : enemy) {
            pQ.add(e);
            n -= e;
            
            if(n<0) {
                if(k<=0) break;
                else {
                    int tmp = pQ.poll();
                    n += tmp;
                    if(n<0) break;
                    answer++;
                    k--;
                }
            }
            else {
                answer++;
            }
        }
        
        return answer;
    }
}