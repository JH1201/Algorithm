import java.util.*;
import java.io.*;

class Node {
    int to;
    int cost;
    
    Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
    
}

public class Main
{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i=0; i<M; i++) {
            int[] tmp = new int[3];
            
            tmp[0] = sc.nextInt();
            tmp[1] = sc.nextInt();
            tmp[2] = sc.nextInt();
            
            list.add(tmp);
            
        }
        
        int start = sc.nextInt();
        int dep = sc.nextInt();
        
        // 특정 마을과 연결 되어있는 노드 목록
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] l : list) {
            int startNode = l[0];
            int endNode = l[1];
            int nodeCost = l[2];
            
            graph.get(startNode).add(new Node(endNode, nodeCost));
        }
        
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Node> pQ = new PriorityQueue<>((a,b) ->a.cost - b.cost);
        
        pQ.offer(new Node(start, 0));
        
        while(!pQ.isEmpty()) {
            
            Node curNode = pQ.poll();
            
            int now = curNode.to;
            int cost = curNode.cost;
            
            if(dist[now] < cost) continue;
            
            for(Node n : graph.get(now)) {
                
                int nextCost = cost + n.cost;
                
                if(nextCost < dist[n.to]) {
                    dist[n.to] = nextCost;
                    pQ.offer(new Node(n.to, nextCost));
                }
            }
        }
        
        System.out.println(dist[dep]);
        
    }
    
}
