import java.util.*;

class Solution {
    public int solution(int storey) {
        int cnt = 0;

        // 각 자릿수별로 올릴지 내릴지를 결정하면서 최소 비용 누적
        while (storey != 0) {
            int n = storey % 10;  // 현재 자리의 숫자
            storey /= 10;         // 상위 자리로 이동

            if (n == 0) continue;  // 0이면 무시

            else if (n < 5) {
                // 내리는 것이 유리한 경우
                cnt += n;
            }
            else if (n > 5) {
                // 올리는 것이 유리 → 올림 처리
                cnt += 10 - n;
                storey++;  // 다음 자리에 올림 carry
            }
            else {
                // n == 5인 경우 → 다음 자리 기준으로 판단
                cnt += 5;
                if (storey % 10 >= 5) storey++;  // 다음 자리가 5 이상이면 올림
            }
        }

        return cnt;
    }
}