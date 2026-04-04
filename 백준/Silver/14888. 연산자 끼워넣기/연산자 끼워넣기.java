
import java.util.*;
import java.io.*;

public class Main
{
    static int[][] map;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[] A = new int[N];
        
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        
        int[] opCnt = new int[4];
        for(int i=0; i<4; i++) {
            opCnt[i] = sc.nextInt();
        }
        
        
        dfs(A, opCnt, 1, N, A[0]);
        
        System.out.println(MAX);
        System.out.println(MIN);
        
    }
    
     
    public static void dfs(int[] A, int[] opCnt, int index, int N, int sum) {
        
        if(index == N) {
            MAX = Math.max(sum, MAX);
            MIN = Math.min(sum, MIN);
            return ;
        }
        
        for(int i=0; i<4; i++) {
            if(opCnt[i] == 0) continue;
            else {
                opCnt[i]--;
                
                switch (i) {
                    case 0 : dfs(A, opCnt, index+1, N, sum+A[index]); break;
                    case 1 : dfs(A, opCnt, index+1, N, sum-A[index]); break;
                    case 2 : dfs(A, opCnt, index+1, N, sum*A[index]); break;
                    case 3 : dfs(A, opCnt, index+1, N, sum/A[index]); break;
                }
                
                opCnt[i]++;
                
            }
            
        }
        
    }
    

}
