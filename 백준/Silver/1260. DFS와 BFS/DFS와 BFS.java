import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

         // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 작은 번호부터 방문하기 위해 정렬
        for(int i=1; i<=N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N+1];
        dfs(V);
        sb.append('\n');

        visited = new boolean[N+1];
        bfs(V);
        System.out.print(sb.toString()); 
    }

    public static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        
        while(!stack.isEmpty()) {
            int curNode = stack.pop();
            if (visited[curNode]) continue;

            else if(!visited[curNode]) {
                visited[curNode] = true;
                sb.append(curNode).append(' ');
                
                List<Integer> linkedNode = graph[curNode];
                for(int i=linkedNode.size()-1; i>=0; i--) {
                    if(!visited[linkedNode.get(i)]) {
                        stack.push(linkedNode.get(i));
                    }
                } 
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        
        while(!q.isEmpty()) {
            int curNode = q.poll();
            sb.append(curNode).append(' ');

            List<Integer> linkedNode = graph[curNode];
            for(int i=0; i<linkedNode.size(); i++) {
                if(!visited[linkedNode.get(i)]) {
                    visited[linkedNode.get(i)] = true;
                    q.offer(linkedNode.get(i));
                }
            } 
        }
    }
}