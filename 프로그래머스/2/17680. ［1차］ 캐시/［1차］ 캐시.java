import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> q = new LinkedList<>();
        
        String[] tmpStr = new String[cities.length];
        
        if(cacheSize == 0) return cities.length * 5; 
        
        for(int i=0; i<cities.length; i++) {
            tmpStr[i] = cities[i].toLowerCase();
        }
        
        for(int i=0; i<cities.length; i++) {
            
            String curCity = tmpStr[i];
            
            if(q.isEmpty()) {
                q.offer(curCity);
                answer += 5;
            }
            else {
                if(q.contains(curCity)) {
                    answer += 1;
                    q.remove(curCity);
                    q.offer(curCity);
                }
                else {
                    if(q.size() >= cacheSize) {
                        q.poll();
                        q.offer(curCity);
                    }
                    else {
                        q.offer(curCity);
                    }
                    answer += 5;
                }
            }
        }
        
        
        return answer;
    }
}