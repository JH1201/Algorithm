
import java.util.*;


public class Main
{
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String arr = sc.nextLine();
        String[] num = arr.split(" ");
        int N = Integer.valueOf(num[0]);
        int K = Integer.valueOf(num[1]);
        
        visited = new boolean[N+1];
        
        for(int i=1; i<=N; i++) {
            //visited[i] = true;
            dfs(N, K, 1, i+" ", i);
            //visited[i] = false;
        }
        
    }
    
    public static void dfs(int N, int K, int depth, String res, int n) {
        
        if(depth == K) {
            System.out.println(res);
            return ;
        }
        
        for(int i=n+1; i<=N; i++) {
            //if(visited[i]) continue;
            
            //visited[i] = true;
            dfs(N, K, depth+1, res + i +" ", i);
            //visited[i] = false;
        }
        
        
    }
    
}
