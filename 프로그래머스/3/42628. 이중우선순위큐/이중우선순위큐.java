import java.util.*;

class Solution {
    PriorityQueue<Integer> maxDeleteQueue = new PriorityQueue<>();
    PriorityQueue<Integer> minDeleteQueue = new PriorityQueue<>(Collections.reverseOrder());
    
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> maxDeleteQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minDeleteQueue = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> resultQueue = new ArrayList<>();
        
        for(String s : operations) {
            
            // 큐에서 최대값 삭제
            if(s.equals("D 1")) {
                if(resultQueue.isEmpty()) continue;
                else {
                    int maxNum = convertToMaxQ(resultQueue);
                    
                    int maxNunIndex = resultQueue.indexOf(maxNum);
                    resultQueue.remove(maxNunIndex);
                }
            }
            
            // 큐에서 최소값 삭제
            if(s.equals("D -1")) {
                if(resultQueue.isEmpty()) continue;
                else {
                    int minNum = convertToMinQ(resultQueue);
                    
                    int minNunIndex = resultQueue.indexOf(minNum);
                    resultQueue.remove(minNunIndex);
                }
            }
            
            else if(s.startsWith("I")) {
                int num = Integer.valueOf(s.substring(2, s.length()));
                resultQueue.add(num);
            }
        }
        
        if(resultQueue.isEmpty()) {
            answer = new int[]{0,0};
        }
        else {
            int maxRes = convertToMaxQ(resultQueue);
            int minRes = convertToMinQ(resultQueue); 
            
            answer = new int[]{maxRes, minRes};
        }

        
        return answer;
    }
    
    public int convertToMinQ(ArrayList<Integer> resQ) {
        maxDeleteQueue.clear();
        
        for(int i=0; i<resQ.size(); i++) {
            maxDeleteQueue.add(resQ.get(i));
        }
        
        return maxDeleteQueue.peek();
    }
    
    public int convertToMaxQ(ArrayList<Integer> resQ) {
        minDeleteQueue.clear();
        
        for(int i=0; i<resQ.size(); i++) {
            minDeleteQueue.add(resQ.get(i));
        }
        
        return minDeleteQueue.peek();
    }
}