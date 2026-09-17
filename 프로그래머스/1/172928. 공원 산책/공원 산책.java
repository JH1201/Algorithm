import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int hLimit = park.length;
        int wLimit = park[0].length();
        
        // 출발지 찾기
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    
                    break;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++) {
            
            String[] tmp = routes[i].split(" ");
                
            String d = tmp[0];
            int l = Integer.parseInt(tmp[1]);
            
            int sum = 0;
            
            switch (d) {
                case "E": 
                    sum = answer[1] + l;
                    if(sum < wLimit && cheakDisable(park, "E", answer, l)) answer[1] = sum;
                    break;
                case "W": 
                    sum = answer[1] - l;
                    if(sum >= 0  && cheakDisable(park, "W", answer, l)) answer[1] = sum;
                    break;
                case "S": 
                    sum = answer[0] + l;
                    if(sum < hLimit  && cheakDisable(park, "S", answer, l)) answer[0] = sum;
                    break;
                case "N": 
                    sum = answer[0] - l;
                    if(sum >= 0  && cheakDisable(park, "N", answer, l)) answer[0] = sum;
                    break;
            }
        }
       
        
        return answer;
    }
    
    public boolean cheakDisable(String[] park, String d, int[] cur, int l) {
        
        int h = cur[0];
        int w = cur[1];
        
        switch (d) {
            case "E": 
                for(int i=w; i<=w+l; i++) {
                    if(park[h].charAt(i) == 'X') return false;
                    else if(i >= park[h].length()) return false;
                }
                
                break;
            case "W": 
                for(int i=w; i>=w-l; i--) {
                    if(park[h].charAt(i) == 'X') return false;
                    else if(i < 0) return false;
                }
                
                break;
            case "S": 
                for(int i=h; i<=h+l; i++) {
                    if(park[i].charAt(w) == 'X') return false;
                    else if(i >= park.length) return false;
                }
                
                break;
            case "N": 
                for(int i=h; i>=h-l; i--) {
                    if(park[i].charAt(w) == 'X') return false;
                    else if(i < 0) return false;
                }
                
                break;
        }
        
        return true;
    }
}