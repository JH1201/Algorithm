import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        
        boolean flag = false;
        
        for(int i : ingredient) {
            
            // stack이 비어있다면 push
            if(s.isEmpty()) s.push(i);
            
            // stack이 비어있지 않을 때
            else {
                s.push(i);
                
                if (s.size() >= 4) {
                    int a = s.get(s.size() - 4);
                    int b = s.get(s.size() - 3);
                    int c = s.get(s.size() - 2);
                    int d = s.get(s.size() - 1);
                    
                    if (a == 1 && b == 2 && c == 3 && d == 1) {
                        s.pop();
                        s.pop();
                        s.pop();
                        s.pop();
                        answer++;
                    }
                }
            }
            
        }
        
        
        return answer;
    }
}