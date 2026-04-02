import java.util.*;

class Node {
    int to; // 어디로 가는지
    int cost; // 이동 비용
    
    Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        
        // 특정 마을과 연결 되어있는 노드 목록
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // road 정보를 graph에 저장
        for(int[] r : road) {
            int startNode = r[0];
            int endNode = r[1];
            int nodeCost = r[2];
            
            // 양방향
            graph.get(startNode).add(new Node(endNode, nodeCost));
            graph.get(endNode).add(new Node(startNode, nodeCost));
        }
        
        // 출발점에서 각 노드까지 가중치 배열
        int[] dist = new int[N+1]; 
        
        // 처음엔 모든 배열에 무한대(최대) 가중치 입력
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        // 현재 노드에서 갈 수 있는 가중치가 제일 적은 노드로 가기 위해 우선순위 큐 사용
        PriorityQueue<Node> pQ = new PriorityQueue<>((a,b) -> a.cost - b.cost); 
        
        // 시작점 푸시
        // 시작점에서 시작점은 그 자리이기 때문에 가중치 0
        pQ.offer(new Node(1, 0));
        
        while(!pQ.isEmpty()) {
            
            Node current = pQ.poll();
            
            int now = current.to; // current에서 이동한 다음 노드
            int cost = current.cost;
            
            if(cost > dist[now]) continue;
            
            // 넘어온 다른 노드에서 갈 수 있는 모든 노드 확인
            for(Node n : graph.get(now)) {
                
                int nextCost = cost + n.cost;
                
                if(nextCost < dist[n.to]) {
                    dist[n.to] = nextCost;
                    
                    pQ.offer(new Node(n.to, nextCost));
                }
            }
            
        }
        
        // 최종적으로 1번 마을에서 각 마을까지의 최단거리가 dist에 저장됨
        // 그중 K 이하인 마을 개수를 세면 정답
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }


        return answer;
    }
}