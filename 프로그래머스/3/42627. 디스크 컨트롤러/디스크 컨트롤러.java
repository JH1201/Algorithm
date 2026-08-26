import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<WorkNode> wQ = new PriorityQueue<>((a, b) -> {
            
            if(a.startTime == b.startTime) {
                return a.workNum - b.workNum;
            }
            
            return a.startTime - b.startTime;
        });
        
        PriorityQueue<WorkNode> rQ = new PriorityQueue<>((a, b) -> {
            
            if(a.duringTime == b.duringTime) {
                if(a.startTime == b.startTime) {
                    return a.workNum - b.workNum;
                }
                
                return a.startTime - b.startTime;
            }
            
            return a.duringTime - b.duringTime;
        });
        
        for(int i=0; i<jobs.length; i++) {
            int workN = i;
            int startT = jobs[i][0];
            int duringT = jobs[i][1];
            
            wQ.add(new WorkNode(duringT, startT, workN));
            
        }
        
        int sum = 0;
        int tmp = 0;
        while(!wQ.isEmpty() || !rQ.isEmpty()) {
            
            while(!wQ.isEmpty() && wQ.peek().getStartTime() <= tmp) {
                rQ.add(wQ.poll());
            }
            
            if(rQ.isEmpty()) {
                tmp = wQ.peek().getStartTime();
                continue;
            }
                
            WorkNode curNode = rQ.poll();
            
            tmp = tmp + curNode.getDuringTime();
            sum += tmp - curNode.getStartTime();
        }
        
        answer = sum/jobs.length;
        
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