import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
       
        // 값 정렬
        Arrays.sort(people);
       
        int i=0; 
        int j=people.length-1;
        int sum = 0;
        
        while(i<=j) {
            sum = people[i] + people[j];
                
            if(i == j) {
                answer++;
                break;
            }
            else if(sum > limit) {
                answer++;
                j--;
            }
            
            else {
                answer++;
                i++;
                j--;
            }
        }
        
        return answer;
    }
}