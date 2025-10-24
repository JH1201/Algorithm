import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        // 간선 입력: BufferedReader + StringTokenizer 로 통일
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) Collections.sort(graph[i]);

        visited = new boolean[N + 1];
        dfsStack(V);
        sb.append('\n');

        Arrays.fill(visited, false);
        bfs(V);

        System.out.print(sb.toString());
    }

    // DFS using Stack (작은 번호 우선 방문을 위해 역순 push)
    static void dfsStack(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (visited[cur]) continue;

            visited[cur] = true;
            sb.append(cur).append(' ');

            List<Integer> nei = graph[cur];
            for (int i = nei.size() - 1; i >= 0; i--) {
                int nxt = nei.get(i);
                if (!visited[nxt]) stack.push(nxt);
            }
        }
    }

    // BFS using Queue (enqueue 시점에 방문 처리)
    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(' ');

            for (int nxt : graph[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    q.offer(nxt);
                }
            }
        }
    }
}
