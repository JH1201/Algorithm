import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int len = sequence.length;
        
        int[] answer = new int[2];
        
        int min = 1000001;
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int arrLen = 1;

        while (left < len && right < len) {

            if (sum < k) {
                right++;
                if(right >= len) break;
                sum += sequence[right];
                arrLen++;
            }
            else if (sum > k) {
                sum -= sequence[left];
                left++;
                arrLen--;
                // left 값 제거
                // left 이동
            }
            else {
                // 현재 left ~ right를 정답 후보와 비교
                if(min > arrLen) {
                    min = arrLen;
                    answer[0] = left;
                    answer[1] = right;
                }

                // 그리고 포인터 하나를 이동시켜야 함
                sum -= sequence[left];
                left++;
                arrLen--;
            }
        }
        
        
        return answer;
    }
}