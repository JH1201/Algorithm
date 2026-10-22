import java.util.*;

class Solution {
    
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        // 곡괭이 갯수, 광물 순서, 피로도, 곡괭이별 채굴 가능 횟수
        answer= dfs(picks, minerals);
        
        return answer;
    }
    
    public int dfs(int[] picks, String[] minerals) {
        
        if(minerals.length == 0) return 0;
        
        int res = Integer.MAX_VALUE;
        
        for(int i=0; i<picks.length; i++) {
            
            if(picks[i] == 0) continue;
            
            int canMingCnt = Math.min(5, minerals.length);
            
            picks[i] -= 1;
            
            int c = 0;
            
            for(int j=0; j<canMingCnt; j++) {
                
                if(i==0) c += 1;
                else if(i == 1) {
                    if(minerals[j].equals("diamond")) c += 5;
                    else c += 1;
                }
                else {
                    if(minerals[j].equals("diamond")) c += 25;
                    else if(minerals[j].equals("iron")) c += 5;
                    else c += 1;
                }
                   
            }
            
            String[] newMinerals = new String[minerals.length - canMingCnt];
            for(int k=0; k<newMinerals.length; k++) {
                newMinerals[k] = minerals[canMingCnt + k];
            }
            
            res = Math.min(res, c + dfs(picks, newMinerals));
            
            picks[i] += 1;
        }
        
        if(res == Integer.MAX_VALUE) return 0;
        
        return res;
    }
   
}