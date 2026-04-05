import java.util.*;
import java.io.*;


public class Main
{
    
    //static String res = "";
    static boolean[] visited;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        visited = new boolean[N+1];
     
        for(int i=1; i<=N; i++) {
            visited[i] = true;
            dfs(i, N, M, 1, i+" ");
            visited[i] = false;
        }
        
    }
    
    public static void dfs(int n, int N, int K, int index, String res) {
        if(index == K) {
            System.out.println(res);
            return ;
        }
        
        
        for(int i=1; i<=N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i, N, K, index+1, res + i +" ");
            visited[i] = false;
        }
        
    }
    
}
