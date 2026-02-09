import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; // 체육 수업을 들을 수 있는 학생 수
        
        
        // 선택 절차
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                
                // 여벌을 가져온 학생옷을 훔쳐갔을 경우
                if(lost[i] == reserve[j]) {
                    answer++;
                    System.out.println("적절성 Test: " + answer + ", i = " + i + ", j = " + j);
                    reserve[j] = -1;
                    lost[i] = -10;
                    break;
                }
                
            }
            
        }
        
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                
                if(reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1) {
                    answer++;
                    System.out.println("해답 Test: " + answer + ", i = " + i + ", j = " + j);
                    reserve[j] = -1;
                    break;
                }
                
            }
            
        }
        
        
        return answer;
    }
}