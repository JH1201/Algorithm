import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 소요시간 짧은 순 > 요청 시각 빠른 순 > 작업의 번호 작은 순
        PriorityQueue<WorkNode> pQ = new PriorityQueue<>((a, b) -> {
            
            if(a.duringTime == b.duringTime && a.startTime == b.startTime) {
                return a.workNum - b.workNum;
            }
            
            else if(a.duringTime == b.duringTime) {
                return a.startTime - b.startTime;
            }
            
            return a.duringTime - b.duringTime;
            
        }); 
        
        PriorityQueue<WorkNode> requestQ = new PriorityQueue<>((a, b) -> {
            
            if(a.startTime == b.startTime) {
                return a.workNum - b.workNum;
            }
            
            return a.startTime - b.startTime;
            
        }); 
        
        for(int i=0; i<jobs.length; i++) {
            int workN = i;            // 작업 번호
            int startT = jobs[i][0];   // 요청 시간
            int duringT = jobs[i][1];  // 소요 시간
                
            WorkNode wNode = new WorkNode(duringT, startT, workN);
            
            requestQ.add(wNode);
            
        }
        
        
        int sum = 0;
        int tmp = 0;    // 현재 시각
        while(!pQ.isEmpty() || !requestQ.isEmpty()) {
            
            // 현재 시간까지 요청이 들어온 작업들을 pQ에 넣음
            while(!requestQ.isEmpty() && requestQ.peek().getStartTime() <= tmp) {
                
                pQ.add(requestQ.poll());
            }
            
            // 현재 실행할 작업이 없다면
            // 다음 작업의 요청 시간까지 시간을 이동
            if(pQ.isEmpty()) {
                tmp = requestQ.peek().getStartTime();
                continue;
            }
            
            
            WorkNode curNode = pQ.poll();
            
            
            tmp = curNode.getDuringTime() + tmp;
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