import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        Integer[] arr = new Integer[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = numbers[i];
        }

        Arrays.sort(arr, (a, b) -> {
            String aStr = Integer.toString(a);
            String bStr = Integer.toString(b);
            
            return (bStr+aStr).compareTo(aStr+bStr);
            
        });
        
        if(arr[0] == 0) return "0";
        
        for(int i : arr) {
            answer += Integer.toString(i);
        }
        /*
        int cnt = 0;
        for(int i=0; i<answer.length(); i++) {
            if(answer.charAt(i) == '0') cnt ++;
        }
        
        if(cnt == answer.length()) return "0";
        */
        
        return answer;
    }
}