import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        //PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        
        Arrays.sort(score);
        
        int t=0;
        int tmp = 0;
        int boxCnt = 1;
        int minNum = 0;
        for(int i = score.length-1; i>=0; i--) {
            tmp += score[i];
            t += 1;
            
            if(t == m) {
                minNum = score[i];
                t = 0;
                tmp = 0;
                
                answer = answer + (minNum * m * boxCnt);
                continue;
            }
        }
        
        return answer;
    }
}