import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length-1;
        
        while(start <= end) {
            int value = people[start] + people[end--];
            if(value <= limit) start++;
            answer++;
        }
       
        return answer;
    }
}