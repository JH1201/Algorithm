import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> q = new LinkedList<>();
        int idx = 0;
        
        if(cacheSize == 0) return cities.length * 5;
        
        for(int i=0; i<cities.length; i++) {
            
            if(q.isEmpty()) {
                q.add(cities[i].toLowerCase());
                answer += 5;
                idx++;
            }
            
            else {
                if(q.contains(cities[i].toLowerCase())) {
                    answer += 1;
                    q.remove(cities[i].toLowerCase());
                    q.add(cities[i].toLowerCase());
                }
                else {
                    if(idx == cacheSize) {
                        q.poll();
                        q.add(cities[i].toLowerCase());
                    }
                    else {
                        q.add(cities[i].toLowerCase());
                        idx++;
                    }
                    
                    answer += 5;
                }
            }
        }
        
        
        return answer;
    }
}