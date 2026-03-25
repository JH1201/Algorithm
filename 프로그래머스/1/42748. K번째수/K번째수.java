import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        //Arrays.sort(array);
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int a=0; a<commands.length; a++) {
            int i=commands[a][0];
            int j=commands[a][1];
            int k=commands[a][2];
            
            for(int b=i-1; b<j; b++) {
                list.add(array[b]);
            }
            
            Collections.sort(list);
            answer[a] = list.get(k-1);
            
            list.clear();
        }
        
        return answer;
    }
}