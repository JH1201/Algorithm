import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        
        Stack<Node> stopedSubject = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        
        Arrays.sort(plans, (a, b) -> {
            return changTime(a[1]) - changTime(b[1]);
        });
        
        int curTime = changTime(plans[0][1]);
        
        HashMap<Node, Integer> map = new HashMap<>();
        
        for(int i=0; i<plans.length-1; i++) {
            
            String[] plan = plans[i];
            
            String subName = plan[0];
            int startTime = changTime(plan[1]);
            int durTime = changTime(plan[2]);
            int endTime = startTime + durTime;
            
            Node curNode = new Node(subName, startTime, durTime, endTime);
            
            String[] nexPlan = plans[i+1];
            
            String nxtSubName = nexPlan[0];
            int nxtStartTime = changTime(nexPlan[1]);
            int nxtDurTime = changTime(nexPlan[2]);
            int nxtEndTime = nxtStartTime + nxtDurTime;
            
            Node nxtNode = new Node(nxtSubName, nxtStartTime, nxtDurTime, nxtEndTime);
            
            if(endTime <= nxtStartTime) {
                list.add(subName);
                map.put(curNode, 0);
                
                int remain = nxtStartTime - endTime;
                
                while(!stopedSubject.isEmpty() && remain > 0) {
                    Node cur = stopedSubject.pop();
                    int curRemain = map.get(cur);
                    
                    // nxtStartTime - endTime 이 시간 안에 가능할 때
                    if(curRemain <= remain) {
                        remain -= curRemain;
                        list.add(cur.subName);
                        map.put(cur, 0);
                    }
                    
                    // 가능하지 않을 때
                    else {
                        map.put(cur, curRemain - remain);
                        stopedSubject.push(cur);
                        remain = 0;
                    }
                }
                
            }
            else {
                int remainTime = endTime - nxtStartTime;
                int r = map.getOrDefault(curNode, remainTime);

                map.put(curNode, remainTime);
                stopedSubject.push(curNode);
            }
            
        }
        list.add(plans[plans.length - 1][0]);
        
        while(!stopedSubject.isEmpty()) {
            Node cur = stopedSubject.pop();
            list.add(cur.subName);
        }
        
        String[] answer = new String[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public int changTime(String time) {
        
        int changedTime = 0;
        
        if(time.contains(":")) {
            String[] t = time.split(":");
        
            int hour = Integer.valueOf(t[0]) * 60;
            int min = Integer.valueOf(t[1]);

            changedTime = hour+min;
        }
        else {
            changedTime = Integer.valueOf(time);
        }
        
        return changedTime;
    }
    
    public class Node {
        String subName = "";
        int startTime = 0;
        int durTime = 0;
        int endTime = 0;
        
        public Node(String sn, int st, int dt, int et) {
            this.subName = sn;
            this.startTime = st;
            this.durTime = dt;
            this.endTime = et;
        }
    }
}