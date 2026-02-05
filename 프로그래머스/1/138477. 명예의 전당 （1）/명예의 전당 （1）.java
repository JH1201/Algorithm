import java.util.PriorityQueue;
import java.util.Collections;
import java.util.*;

class Solution {
    public ArrayList solution(int k, int[] score) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i : score) {
            pQueue.add(i);
            
            if(pQueue.size() > k) {
                pQueue.poll(); 
                answer.add(pQueue.peek());
            }
            else {
                answer.add(pQueue.peek());
            }
            
        }
        
        return answer;
    }
}