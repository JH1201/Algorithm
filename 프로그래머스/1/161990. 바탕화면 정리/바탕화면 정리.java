import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        HashMap<int[], Integer> map = new HashMap<>();
        
        int i=0;
        int[] point = new int[2];
        
        int minX = 51;
        int maxX = 0;
        int minY = 51;
        int maxY = 0;
        
        for(String s : wallpaper) {
            for(int j=0; j<s.length(); j++) {
                point[0] = i;
                point[1] = j;
                
                map.put(point, getLength(point));
                
                if(s.charAt(j) == '#') {
                    if(j < minY) minY = j;
                    if(i < minX) minX = i;
                    if(j > maxY) maxY = j;
                    if(i > maxX) maxX = i;
                }
            }
            i++;
        }
        
        maxX+=1;
        maxY+=1;
        
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX;
        answer[3] = maxY;
        
        
        return answer;
    }
    
    public int getLength(int[] point) {
        return (point[0]-0) + (point[1]-0);
    }
}