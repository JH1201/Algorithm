import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<WorkNode> waitingQueue = new PriorityQueue<>((a, b) -> {
            
            // 작업 시간 > 요청 시각 > 작업 번호 작은 순 
            if(a.getStartTime() == b.getStartTime()) {
                return a.workNum - b.workNum;
            }
            
            return a.getStartTime() - b.getStartTime();
            
        });
        
        PriorityQueue<WorkNode> resultQ = new PriorityQueue<>((a, b) -> {
            
            // 작업 시간 > 요청 시각 > 작업 번호 작은 순 
            if(a.getDuringTime() == b.getDuringTime()) {

                if(a.getStartTime() == b.getStartTime()) {
                    return a.workNum - b.workNum;
                }

                return a.startTime - b.startTime;
            }
            
            return a.duringTime - b.duringTime;
            
        });
        
        for(int i=0; i<jobs.length; i++) {
            
            int workNum = i;               // 작업 번호
            int duringTime = jobs[i][1];   // 작업 시간
            int startTime = jobs[i][0];   // 요청 시각
            
            waitingQueue.add(new WorkNode(duringTime, startTime, workNum));
            
        }
        
        int sum = 0;
        int tmp = 0;
        while(!waitingQueue.isEmpty() || !resultQ.isEmpty()) {
            
            
            
            while(!waitingQueue.isEmpty() && tmp >= waitingQueue.peek().getStartTime()) {
                resultQ.add(waitingQueue.poll());
            }
            
            if(resultQ.isEmpty()) {
                tmp = waitingQueue.peek().getStartTime();
                continue;
            }
            
            WorkNode curNode = resultQ.poll();
            
            tmp = tmp + curNode.getDuringTime();
            sum += tmp - curNode.getStartTime();
            
        }
        
        //System.out.println("sum = " + sum + ", tmp = " + tmp);
        
        answer = sum / jobs.length;
        
        return answer;
    }
    
    
    class WorkNode {
        int duringTime;   // 작업 시간
        int startTime;    // 요청 시각
        int workNum;      // 작업 번호
        
        public WorkNode(int d, int s, int wn) {
            this.duringTime = d;
            this.startTime = s;
            this.workNum = wn;
        }
        
        public int getStartTime() {
            return this.startTime;
        }
        
        public void setStartTime(int st) {
            this.startTime = st;
        }
        
        public int getDuringTime() {
            return this.duringTime;
        }
        
        public void setDuringTime(int dt) {
            this.duringTime = dt;
        }
        
        
    }
}