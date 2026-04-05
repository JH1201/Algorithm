import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length-1;
        
        int sum = 0;
        
        while(start<=end) {
            
            sum = people[start]+people[end];
            
            if(start==end) {
                answer++;
                break;
            }
            
            if(sum > limit) {
                answer++;
                end--;
            }
            else {
                answer++;
                end--;
                start++;
            }
            
        }
       
        return answer;
    }
}