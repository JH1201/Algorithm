import java.util.*;

class Solution {
    
    boolean[][] v;
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        Queue<Node> q = new LinkedList<>();
        
        Node startNode = new Node(0,0,1);
        q.add(startNode);
        
        int targetI = maps.length-1;
        int targetJ = maps[0].length-1;
        
        //System.out.println(targetI + ", " + targetJ);
        
        while(!q.isEmpty()) {
            
            Node curNode = q.poll();
            
            //System.out.println(curNode.getX() + ", " + curNode.getY());
             
            
            // 목표 지점일 때 break
            if(curNode.getX() == targetI && curNode.getY() == targetJ) {
                answer = curNode.getCost();
                break;
            }
            
            if(maps[curNode.getX()][curNode.getY()] == 0) continue;
            
            // 현재 노드 방문처리
            maps[curNode.getX()][curNode.getY()] = 0;
            
            // 현재 노드에서 갈 수 있는 Node 큐에 삽입
            int[] x = {1, -1, 0, 0};
            int[] y = {0, 0, -1, 1};
            
            for(int i=0; i<4; i++) {
                int dx = curNode.getX() + x[i];
                int dy = curNode.getY() + y[i];
                
                if(dx < 0 || dx > targetI || dy < 0 || dy > targetJ) continue;
                if(maps[dx][dy] == 0) continue;
                
                Node nextNode = new Node(dx, dy, curNode.getCost() + 1);
                q.offer(nextNode);
            }
            
        }
        
            
        return answer;
    }
    
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
}