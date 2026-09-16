import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> right = new HashMap<>();
        HashSet<Integer> left = new HashSet<Integer>();
        
        for(int t : topping) {
            if(right.get(t) == null) right.put(t, 1);
            else right.put(t, right.get(t)+1);
        }
        
        for(int i=0; i<topping.length; i++) {
            
            int goLeft = topping[i];
            
            left.add(goLeft);
            
            int tmp = right.get(goLeft)-1;
            
             if(tmp == 0) {
                right.remove(goLeft);
            } 
            
            else {
                right.put(goLeft, tmp);
            }
            
            //System.out.println(i + " 번째: " + "goLeft: " + goLeft + " / left: " + left.size() + ", right: " + right.keySet().size());
            //System.out.println(tmp);
            
            if(right.keySet().size() == left.size()) answer++;
        }
        
        
        return answer;
    }
}