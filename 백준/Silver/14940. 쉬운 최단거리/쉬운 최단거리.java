import java.util.*;
import java.io.*;

class Node {
    int n;
    int m;
    int cost;
    
    Node(int n, int m, int cost) {
        this.n = n;
        this.m = m;
        this.cost = cost;
    }
}

public class Main
{
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 입력 Map
        int[][] map = new int[N+1][M+1];
        
        // 결과 Map
        int[][] resMap = new int[N+1][M+1];
        
        int locationN = 0;
        int locationM = 0;
        
        // bfs
        Queue<Node> q = new LinkedList<>();
        
        // map 생성
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if(map[i][j] == 2) {
                    locationN = i;
                    locationM = j;
                    q.offer(new Node(i, j, 0));
                }
                
            }
        }
        
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        
        while(!q.isEmpty()) {
            
            Node now = q.poll();
            
            // 이미 방문한 노드는 건너뜀
            if(resMap[now.n][now.m] != 0) {
                continue;
            }
            if((now.n == locationN && now.m == locationM) || map[now.n][now.m] != 0) {
                resMap[now.n][now.m] = now.cost;
            }
            
            for(int i=0; i<4; i++) {
                int nx = now.n+dx[i];
                int ny = now.m+dy[i];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= M)continue;
                else if(map[nx][ny] == 0) continue;
                else if(nx == locationN && ny == locationM) continue;
                
                q.offer(new Node(nx, ny, now.cost+1));
            }
        }
        
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(resMap[i][j] == 0 && map[i][j] != 0 && !(i == locationN && j == locationM)) {
                    System.out.print("-1 ");
                }
                else {
                    System.out.print(resMap[i][j] + " ");
                }
                
            }
            System.out.println();
        }
        
    }
}