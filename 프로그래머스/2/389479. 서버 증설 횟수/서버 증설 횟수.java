import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        Queue<String> madeServer = new LinkedList<>();   // 증설된 서버
        Queue<Integer> timer = new LinkedList<>();
        
        int serverCounting = 1;
        
        for(int i=0; i<players.length; i++) {
            
            // 서버 증설을 k시간 동안만 유지
            if(!timer.isEmpty()) {
                
                int timerSize = timer.size();
                
                for(int j=0; j<timerSize; j++) {
                    int t = timer.poll() - 1;
                    String tmp = madeServer.poll();
                    
                    if(t == 0) {
                        //System.out.println(i + " ~ " + (i+1) + " / " + tmp + " 서버가 timeout 되었습니다.");
                        //System.out.println("server cnt = " + madeServer.size());
                    }
                    else {
                        timer.add(t);
                        madeServer.add(tmp);
                    }   
                }
            }
            
            // 플레이어가 m 보다 많아 질 때 서버 증설
            // 서버가 증설 됐을 때 timer 시작
            if(m <= players[i]) {
                
                if(madeServer.size() >= players[i]/m) continue;
                
                int limit = players[i]/m - madeServer.size();
                answer += limit;
                
                for(int a=0; a<limit; a++) {
                    madeServer.add("Server" + Integer.toString(serverCounting));
                    timer.add(k);
                    //System.out.println(i + " ~ " + (i+1) + " / " + "Server" + Integer.toString(serverCounting) + " 서버가 증설 되었습니다." );
                    serverCounting++;
                }
                
                //System.out.println("answer = " + answer + " / server cnt = " + madeServer.size());
            }
        }
        
        return answer;
    }
}