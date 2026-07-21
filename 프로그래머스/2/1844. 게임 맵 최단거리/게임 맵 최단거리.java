import java.util.*;

class Solution {
    
    class Node {
        int x;
        int y;
        int cost;
        
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        
        int getX() {
            return this.x;
        }
        
        int getY() {
            return this.y;
        }
        
        int getCost() {
            return this.cost;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        Queue<Node> q = new LinkedList<>();
        int[][] visited = maps.clone();
        
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        
        q.offer(new Node(0,0,1));
        
        while(!q.isEmpty()) {
            
            // queue 꺼내고
            Node cur = q.poll();
            
            int curX = cur.getX();
            int curY = cur.getY();
            int curC = cur.getCost();
            
            if(visited[curX][curY] == 0 || maps[curX][curY] == 0) continue;
            
            if(curX == maps.length-1 && curY == maps[0].length-1) {
                answer = cur.getCost();
                break;
            }
            
            // 방문 처리
            visited[curX][curY] = 0;
            
            // 갈 수 있는 방향 queue에 저장
            for(int j=0; j<4; j++) {

                int x = curX+dx[j];
                int y = curY+dy[j];

                if(x < 0 || y < 0 || x >= maps.length || y >= maps[0].length) {
                    continue;
                } 
                if(visited[x][y] == 0 || maps[x][y] == 0) {
                    continue;
                }
                q.offer(new Node(x, y, curC+1));
            }
            
        }
        
            
        return answer;
    }
}