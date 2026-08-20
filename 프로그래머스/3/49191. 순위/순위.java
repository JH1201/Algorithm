import java.util.*;

class Solution {
    
    int BIGNUM = 1000000;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] arr = new int[n+1][n+1];
        
        ArrayList<Integer> list = new ArrayList<>();
        

        // 배열 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = BIGNUM;
                }
            }
        }

         // 경기 결과 저장
        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];

            arr[winner][loser] = 1;
        }
        
        // 플로이드-워셜
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            int cnt = 0;
            
            for(int j=1; j<=n; j++) {
                if((arr[i][j] != BIGNUM || arr[j][i] != BIGNUM) && (arr[i][j] != 0 || arr[j][i] != 0)) cnt++;
            }
            
            if(cnt == (n-1)) answer++;
        }
        
        return answer;
    }
    
    
}