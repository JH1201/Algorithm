import java.util.*;
import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        Integer[] arr = new Integer[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = numbers[i];
        }
        
        Arrays.sort(arr, (a, b) -> {
            String t1 = Integer.toString(a);
            String t2 = Integer.toString(b);
            
            return (t2+t1).compareTo(t1+t2);
        });
        
        if(arr[0] == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int i : arr) {
            sb.append(Integer.toString(i));
        }
        
        answer = sb.toString();
        
        return answer;
    }
}