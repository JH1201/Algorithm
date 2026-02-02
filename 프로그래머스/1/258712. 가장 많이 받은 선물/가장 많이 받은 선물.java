import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        // 이름 -> 인덱스
        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) idx.put(friends[i], i);

        // give[i][j] = i가 j에게 준 선물 횟수
        int[][] give = new int[n][n];
        int[] given = new int[n];     // i가 전체에게 준 횟수
        int[] received = new int[n];  // i가 전체에게 받은 횟수

        for (String g : gifts) {
            String[] parts = g.split(" ");
            int a = idx.get(parts[0]);
            int b = idx.get(parts[1]);
            give[a][b]++;
            given[a]++;
            received[b]++;
        }

        // 선물지수 = 준 - 받은
        int[] giftIndex = new int[n];
        for (int i = 0; i < n; i++) giftIndex[i] = given[i] - received[i];

        // next[i] = 다음 달 i가 받을 선물 개수
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ij = give[i][j];
                int ji = give[j][i];

                if (ij > ji) next[i]++;
                else if (ji > ij) next[j]++;
                else {
                    // 주고받은 수가 같거나(0 포함) 기록이 없으면 선물지수 비교
                    if (giftIndex[i] > giftIndex[j]) next[i]++;
                    else if (giftIndex[j] > giftIndex[i]) next[j]++;
                }
            }
        }

        int ans = 0;
        for (int v : next) ans = Math.max(ans, v);
        return ans;
    }
}
