import java.util.*;

class Solution {
    
    boolean[] v;
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        v = new boolean[picks.length];
        
        // 곡괭이 갯수, 광물 순서, 피로도, 곡괭이별 채굴 가능 횟수
        answer = dfs(picks, minerals);
        
        return answer;
    }
    
    public int dfs(int[] picks, String[] minerals) {
        
        if(minerals.length == 0) return 0;
        
        int res = Integer.MAX_VALUE;
        
        
        for(int i=0; i<picks.length; i++) {
            
            if(picks[i] == 0) continue;
            
            // 곡괭이 사용
            picks[i] = picks[i] - 1;
            
            int canMiningLen = Math.min(5, minerals.length);
            int fatigue = 0;

            // 곡괭이 종류
            int rhr = i;
            
            for(int j=0; j<canMiningLen; j++) {
                if(rhr == 0) {
                    fatigue += 1;
                }
                
                else if(rhr == 1) {
                    if(minerals[j].equals("diamond")) fatigue += 5;
                    else fatigue += 1;
                }
                
                else {
                    if(minerals[j].equals("diamond")) fatigue += 25;
                    else if(minerals[j].equals("iron")) fatigue += 5;
                    else fatigue += 1;
                }
            }
            
            String[] newMinerals = new String[minerals.length - canMiningLen];

            for(int j=0; j<newMinerals.length; j++) {
                newMinerals[j] = minerals[canMiningLen + j];
            }
        
            res = Math.min(res, fatigue + dfs(picks, newMinerals));    
            
            // 백트랙킹
            picks[i] = picks[i] + 1;
        }
        
        // 사용할 곡괭이가 하나도 없는 경우
        if(res == Integer.MAX_VALUE) return 0;
        
        return res;
    }
}