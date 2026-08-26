import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        
        int answer = 0;
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0 ;i<priorities.length; i++) {
            pQ.add(priorities[i]);
            q.add(new int[] {priorities[i], i});    

        }
        
        while(!pQ.isEmpty()) {
            
            // [priorities, 순번]
            int[] curNode = q.poll();
            
            
            if(curNode[0] == pQ.peek()) {
                pQ.poll();
                answer++;
                
                if(location == curNode[1]) break;
            }
            else {
                q.add(curNode);
            }
        }
        
        
        return answer;
    }
        
    class Node {
        char c;
        int x;
        
        public Node(char c, int x) {
            this.c = c;
            this.x = x;
        }
    }
}