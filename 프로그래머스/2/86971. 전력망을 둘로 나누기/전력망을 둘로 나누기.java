import java.util.*;

class Node {
    int start;
    int to;
    
    Node(int start, int to) {
        this.start = start;
        this.to = to;
    }
}

class Solution {
    
    boolean[] visited;
    int sum = 0;
    
    public int solution(int n, int[][] wires) {
        int answer = 100;

        for(int[] w : wires) {
            // w를 끊었을 때 두 송전탑 사이의 개수
            if(answer > findCount(w, wires, n)) answer = findCount(w, wires, n);
        }
        
        return answer;
    }
    
    public int findCount(int[] w, int[][] wires, int N) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N+1];
        
        // 각 노드에서 갈 수 있는 노드 저장
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 각 노드에서 갈 수 있는 노드 저장
        for(int[] way : wires) {
            
            // 전선 w가 끊겨있기 때문에 continue
            if(way[0] == w[0] && way[1] == w[1]) continue;
            
            int startNode = way[0];
            int endNode = way[1];
            
            graph.get(startNode).add(new Node(startNode, endNode));
            graph.get(endNode).add(new Node(endNode, startNode));
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=1; i<=N; i++) {
            if(visited[i]) continue;
            dfs(i, graph);
            res.add(sum);
            sum = 0;
        }
        
        int result = res.get(0) -res.get(1);
        
        if(result < 0) result = -1 * result;
        
        return result;
        
    }
    
    public void dfs(int nodeNum, ArrayList<ArrayList<Node>> g) {
        
        if(visited[nodeNum]) return ;
        visited[nodeNum] = true;
        sum += 1;
        
        ArrayList<Node> ableNode = g.get(nodeNum);
        
        for(Node n : ableNode) {
            dfs(n.to, g);
        }
        
    }
}