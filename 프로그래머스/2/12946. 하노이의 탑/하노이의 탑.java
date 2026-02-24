import java.util.*;

class Solution {
    
    Queue<Integer> q = new LinkedList<>();
    int i = 0;
    int[][] answer = {};
    public int[][] solution(int n) {
        int t = (int)Math.pow(2,n)-1;
        
        answer = new int[t][2];
        
        hanoi(n,1,2,3);
        return answer;
    }
    
    public void move(int order, int start, int end) {
        //System.out.println(Integer.toString(order) + "번째 원반을 " + Integer.toString(start) + "번 에서 " + Integer.toString(end) + "로 이동");
        
        answer[i][0] = start;
        answer[i][1] = end;
        i++;
    }
    
    public void hanoi(int num, int start, int via, int end) {
        if(num == 1) {
            move(1, start, end);
        }
        else {
            hanoi(num-1, start, end, via);
            move(num, start, end);
            hanoi(num-1, via, start, end);
        }
        
    }
}