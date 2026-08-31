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
        
        q.offer(new Node(0, 0, 0));
        
        int endX = maps.length-1;
        int endY = maps[0].length-1;
            
        while(!q.isEmpty()) {
            
            Node curNode = q.poll();
            int curX = curNode.getX();
            int curY = curNode.getY();
            
            // 목적지 노드일 때
            if(curX == endX && curY == endY) {
                answer = curNode.getCost()+1;
                break;
            }
            
            // 방문한 노드 or 벽일 때
            if(maps[curX][curY] == 0) {
                continue;
            }
            
            // 현재 노드 방문 처리
            maps[curX][curY] = 0;
            
            int[] x = {0, 0, 1, -1};
            int[] y = {1, -1, 0, 0};
            
            // 갈 수 있는 노드 queue에 삽입
            for(int i=0; i<4; i++) {
                int dx = x[i] + curX;
                int dy = y[i] + curY;
                
                if(dx < 0 || dy < 0 || dx >= maps.length || dy >= maps[0].length || maps[dx][dy] == 0) {
                    continue;
                } 
                q.offer(new Node(dx, dy, curNode.getCost()+1));
            }
            
        }
        
            
        return answer;
    }
}