import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        ArrayList<Integer> list = new ArrayList<>();
        
        
        String[] numArr = s.split(" ");
        
        for(int i=0; i<numArr.length; i++) {
            int n = Integer.valueOf(numArr[i]);
            list.add(n);
        }
        
        Collections.sort(list);
        
        answer = String.valueOf(list.get(0)) + " " + String.valueOf(list.get(list.size()-1));
        
        return answer;
    }
}