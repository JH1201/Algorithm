import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        
        String[] answer = new String[plans.length];
        ArrayList<String> ansList = new ArrayList<>();
        
        // 과목 이름, 남은 시간 저장
        Stack<String[]> stack = new Stack<>();
        
        Arrays.sort(plans, (a, b) -> {
            int aTime = getTime(a[1]); 
            int bTime = getTime(b[1]);
            
            return aTime - bTime;
            
        });
        
        for(int i=0; i<plans.length-1; i++) {
            //System.out.println("과제: " + i+ "번째");
            String curSub = plans[i][0];
            int curTime = getTime(plans[i][1]);
            int curDur = Integer.valueOf(plans[i][2]);
            
            String nxtSub = plans[i+1][0];
            int nxtTime = getTime(plans[i+1][1]);
            int nxtDur = Integer.valueOf(plans[i+1][2]);
            
            // 다음 과제 시간전에 기존 과제를 끝낼 수 있을 때
            if(curTime+curDur <= nxtTime) {
                ansList.add(curSub);
                
                int nxRemainTime = nxtTime - curTime - curDur;
                //System.out.println(nxtTime + ", " + curTime + ", " + curDur);
            
                // 다음 과제 전 시간이 남았을 때
                while(!stack.isEmpty() && nxRemainTime > 0) {
                    //System.out.println("다음 과제까지 남은 시간: " + nxRemainTime);
                    
                    String[] tmpS = stack.pop();

                    int nxT = Integer.valueOf(tmpS[1]);

                    // 남은 시간안에 과제를 끝냈을 때
                    if(nxT <= nxRemainTime) {
                        //System.out.println("다음 과제전 이전 과제를 끝냈음");
                        ansList.add(tmpS[0]);
                        nxRemainTime = nxRemainTime - nxT;
                    }

                    // 남은 시간안에 과제를 끝내지 못 했을 때
                    else {
                        //System.out.println("다음 과제전 이전 과제를 끝내지 못 했음");
                        int iT = nxT - nxRemainTime;

                        String[] tSub = {tmpS[0], Integer.toString(iT)};
                        stack.push(tSub);
                        
                        break;
                    }
                    
                } 
                
                //  다음 과제 전 시간이 남지 않았을 때
                /*
                else if(nxRemainTime == 0) {
                    System.out.println("다음 과제를 바로 시작해야 됩니다.");
                }
                */
                
            }
            
            // 다음 과제 시간전에 기존 과제를 끝낼 수 없을 때
            else {
                
                // 과제가 넘어갔을 때 기존 과제의 남은 시간
                String remain = Integer.toString(curTime+curDur-nxtTime);
                
                String[] sub = {curSub, remain};
                stack.push(sub);
            }
            
           
        }
        String lastSub = plans[plans.length - 1][0];
        ansList.add(lastSub);
        
        while(!stack.isEmpty()) {
            String[] t = stack.pop();
            ansList.add(t[0]);
        }
        
        for(int i=0; i<ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }
        
        return answer;
    }
    
    public int getTime(String str) {
        String[] t = str.split(":");
        
        int hour = 60 * Integer.valueOf(t[0]);
        int min = Integer.valueOf(t[1]);
        
        return hour + min;
    }
}