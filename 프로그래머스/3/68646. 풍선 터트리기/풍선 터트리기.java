import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        boolean[] v = new boolean[a.length];
        int leftMin = Integer.MAX_VALUE;;
        int rightMin = Integer.MAX_VALUE;
        
        for(int i=0; i<a.length; i++) {
            if(a[i] < leftMin) {
                leftMin = a[i];
                v[i] = true;
            }
        }
        
        for(int i=a.length-1; i>=0; i--) {
            if(a[i] < rightMin) {
                rightMin = a[i];
                v[i] = true;
            }
        }
        
        
        for(int i=0; i<v.length; i++) {
            if(v[i]) answer++;
        }
        
        return answer;
    }
    
    
}