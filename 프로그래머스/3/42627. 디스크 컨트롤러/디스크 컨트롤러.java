import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 대기 큐 
        // 겹치는 작업은 대기큐에 넣고 우선순위가 높은 것 부터 사용
        // 작업 시간이 짧은 > 요청 시각이 빠른 > 작업의 번호가 작은 순
        PriorityQueue<WorkNode> waitingQueue = new PriorityQueue<>((a, b) -> {
            if(a.getStartTime() == b.getStartTime()) {
                
                return a.getIndex() - b.getIndex();
            }
               
            return a.getStartTime() - b.getStartTime();
        });
        
        PriorityQueue<WorkNode> runningQueue = new PriorityQueue<>((a, b) -> {
            if(a.getDuringTime() == b.getDuringTime()) {
                
                if(a.getStartTime() == b.getStartTime()) {
                     return a.getIndex() - b.getIndex();
                }
                
                return a.getStartTime() - b.getStartTime();
            }
               
            
            return a.getDuringTime() - b.getDuringTime();
        });
        
        for(int i=0; i<jobs.length; i++) {
            waitingQueue.add(new WorkNode(i, jobs[i][1], jobs[i][0]));
        }
        
        int curTime = 0;
        int total = 0 ;
        while(!waitingQueue.isEmpty() || !runningQueue.isEmpty()) {
            
            while(!waitingQueue.isEmpty() && waitingQueue.peek().getStartTime() <= curTime) {
                 runningQueue.add(waitingQueue.poll());
            }
            if(runningQueue.isEmpty()) {
                curTime = waitingQueue.peek().getStartTime();
                continue;
            }
            
            WorkNode curNode = runningQueue.poll();
            
            curTime += curNode.getDuringTime();
            total += curTime - curNode.getStartTime();
            
        }
        
        answer = total / jobs.length;
        
        return answer;
    }
    
    class WorkNode {
        int index;
        int duringTime;
        int startTime;
        
        public WorkNode(int i, int d, int s) {
            this.index = i;
            this.duringTime = d;
            this.startTime = s;
        }
        
        public int getIndex() {
            return this.index;
        }
        
        public void setIndex(int i) {
            this.index = i;
        }
        
        public int getDuringTime() {
            return this.duringTime;
        }
        
        public void setDuringTime(int d) {
            this.duringTime = d;
        }
        
        public int getStartTime() {
            return this.startTime;
        }
        
        public void setStartTime(int s) {
            this.startTime = s;
        }
    }
    
}