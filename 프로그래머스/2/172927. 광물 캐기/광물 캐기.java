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
            
            picks[i] = picks[i] - 1; // 곡괭이 하나 사용
            
            // 하나당 5개 광물 최대
            int maxMining = Math.min(5, minerals.length);
            
            // 피로도
            int tired = 0;
            
            for(int j=0; j<maxMining; j++) {
                if(i==0) tired += 1; // 곡괭이가 다이아몬드일 때
                
                // 곡괭이가 철일 때
                else if(i == 1) {
                    if(minerals[j].equals("diamond")) tired += 5;
                    else tired += 1;
                }
                
                else {
                    if(minerals[j].equals("diamond")) tired += 25;
                    else if(minerals[j].equals("iron")) tired += 5;
                    else tired += 1;
                }
                    
            }
            
            String[] newMinerals = new String[minerals.length - maxMining];
            for(int k=0; k<newMinerals.length; k++) {
                newMinerals[k] = minerals[maxMining + k];
            }
            
            res = Math.min(res, tired + dfs(picks, newMinerals));
            
            picks[i] = picks[i] + 1; // 백트래킹
            
        }
        
        if(res == Integer.MAX_VALUE) return 0;
        
        return res;
    }
}