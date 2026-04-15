import java.util.*;
import java.io.*;

public class Main
{
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        // 문제에서 N은 최대 40
        int[][] dp = new int[41][2];

        // 초기값
        dp[0][0] = 1;
        dp[0][1] = 0; 
        dp[1][0] = 0; 
        dp[1][1] = 1; 
        
        // 미리 40까지 계산
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }
        
        System.out.print(sb.toString());
    }
    
    
}
