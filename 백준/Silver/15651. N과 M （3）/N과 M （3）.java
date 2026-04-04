
import java.util.*;
import java.lang.*;


public class Main
{
    static boolean[] visited;
    static StringBuilder answer = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String arr = sc.nextLine();
        String[] num = arr.split(" ");
        int N = Integer.valueOf(num[0]);
        int K = Integer.valueOf(num[1]);
        
        visited = new boolean[N+1];
        
        StringBuilder sb = new StringBuilder("");
        
        dfs(N, K, 0, sb);
        
        System.out.println(answer);
        
        
    }
    
    public static void dfs(int N, int K, int depth, StringBuilder res) {
        
        if(depth == K) {
            answer.append(res.toString().trim()).append('\n');
            return ;
        }
        
        for(int i=1; i<=N; i++) {
            int len = res.length();
            res.append(i).append(' ');
            dfs(N, K, depth+1, res);
            res.setLength(len);
        }
    }
}
