import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        ArrayList<Integer> ans = new ArrayList<>();
       
        int[][] map = new int[n][n];
        
        int h = 0;
        int w = 0;
        int num = 1;
        
        while(n > 0) {
            
            // n번 아래로
            for(int i=0; i<n; i++) {
                map[h+i][w] = num++;
            }
            h = h + n - 1;
            w++;
            n--;
            
            // n--번 오른쪽
            for(int i=0; i<n; i++) {
                map[h][w+i] = num++;
            }
            w = w + n - 1;
            h--;
            w--;
            n--;
            
            
            
            // n--번 대각선 위
            for(int i=0; i<n; i++) {
                map[h-i][w-i] = num++;
            }
            h = h - (n - 1);
            w = w - (n - 1);
            
            h++;
            n--;
            
        }
        
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j] != 0) ans.add(map[i][j]);
                //System.out.print(map[i][j] + " "); 
            }
            //System.out.println();
        }
        
        int[] answer = new int[ans.size()];
        
        for(int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}