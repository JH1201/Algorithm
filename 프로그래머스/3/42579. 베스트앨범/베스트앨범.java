import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        HashMap<Integer, HashMap<String, Integer>> map = new HashMap<>();   // 고유번호별 수록곡
        HashMap<String, Integer> cntMap = new HashMap<>();                  // 장르 재생 횟수
        
        for(int i=0; i<genres.length; i++) {
            
            if(cntMap.get(genres[i]) == null) {
                cntMap.put(genres[i], plays[i]);
            }
            else {
                cntMap.put(genres[i], cntMap.get(genres[i]) + plays[i]);
            }
            
            HashMap<String, Integer> playTimes = new HashMap<>();  
            playTimes.put(genres[i], plays[i]);
                
            map.put(i, playTimes);
        }
        
        
        while(cntMap.size() != 0) {
            
            int totalPlays = 0;
            String bestGenres = "";
            
            // 속한 노래가 많이 재생된 장르 선택
            for(String key : cntMap.keySet()) {
                if(cntMap.get(key) > totalPlays) {
                    totalPlays = cntMap.get(key);
                    bestGenres = key;
                }
            }
            
            int firstIndex = -1;
            int secIndex = -1;
            int max = -1;
            int secMax = -1;
            
            for(int i=0; i<genres.length; i++) {
                HashMap<String, Integer> tmp = map.get(i);
                
                for(String k : tmp.keySet()) {
                    if(!bestGenres.equals(k)) continue;

                    if(max < tmp.get(k)) {
                        secMax = max;
                        max = tmp.get(k);
                        secIndex = firstIndex;
                        firstIndex = i;
                    }
                    else if(max == tmp.get(k)) {
                        if(tmp.get(k) > secMax) {
                            secMax = tmp.get(k);
                            secIndex = i;
                        }
                    }
                    else {
                        if(max > tmp.get(k) && secMax < tmp.get(k)) {
                            secIndex = i;
                            secMax = tmp.get(k);
                        } 
                    }
                }
            }
            ans.add(firstIndex);
            if(secIndex != -1) ans.add(secIndex);
            
            cntMap.remove(bestGenres);
        }
        
        int[] answer = new int[ans.size()];
        
        for(int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}