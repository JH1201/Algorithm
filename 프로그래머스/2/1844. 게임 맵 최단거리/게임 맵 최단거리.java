import java.util.*;

class Solution {
    Queue<Node> q = new LinkedList<>();
    boolean[][] visited = new  boolean[100][100];
    
    class Node {
        int x;
        int y;
        int cost;
        
        Node(int x, int y,int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;            
        }
    }
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
      
        // 큐에 첫번째 상태 입력
        q.add(new Node(0, 0, maps[0][0]));
        
        while(!q.isEmpty()) {
            
            Node curNode = q.poll();
            
            if(visited[curNode.x][curNode.y]) continue;
            if(curNode.x == maps.length-1 && curNode.y == maps[0].length-1) {
                answer  = curNode.cost;
                break;
            }
            
            // 방문 등록
            visited[curNode.x][curNode.y] = true;
            
            // 현재 노드가 갈 수 있는 노드 탐색
            for(int i=0; i<4; i++) {
                int x = dx[i] + curNode.x;
                int y = dy[i] + curNode.y;

                // 벽이거나 map 밖일 때 제외
                if(y < 0 || x < 0 || x >= maps.length || y >= maps[0].length ) {
                    continue;
                }
                if(maps[x][y] == 1) {
                    q.add(new Node(x, y, curNode.cost+1));
                }
            }
            
        }
        
        return answer;
    }
}