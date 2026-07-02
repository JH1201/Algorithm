import java.util.*;

class Node {
    int x;
    int y;
    int cost;
    
    Node(int x, int y, int cost) {
        this.x= x;
        this.y = y;
        this.cost = cost;
    }
}

class Solution {
    
    boolean[][] visited;
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    Queue<Node> q = new LinkedList<>();
    int answer = 0;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        boolean[][] boundary = getBoundary(rectangle);
        
        visited = new boolean[boundary.length][boundary[0].length];
        
        // 첫번째 노드 등록
        q.add(new Node(characterX*2, characterY*2, 0));
        visited[characterX*2][characterY*2] = true;
        
        bfs(boundary, itemX*2, itemY*2);
     
        return answer;
    }
    
   public void bfs(boolean[][] boundary, int itemX, int itemY) {
       
       while(!q.isEmpty()) {
           
           Node curNode = q.poll();
           
           if(curNode.x == itemX && curNode.y == itemY) {
               answer = curNode.cost / 2;
               break;
           }
           
           for(int i=0; i<4; i++) {
               int x = dx[i] + curNode.x;
               int y = dy[i] + curNode.y;
               
               if(x < 0 || y < 0 || x >= boundary.length || y >= boundary[0].length) {
                   continue;
               }
               
               if(visited[x][y]) continue;
               
               if(!boundary[x][y]) continue;

               visited[x][y] = true;
               q.add(new Node(x, y, curNode.cost+1));
               
               
           }
       }
   }
    
    public boolean[][] getBoundary(int[][] rectangle) {
        
        int maxX = 0;
        int maxY = 0;
        
        for(int i=0; i<rectangle.length; i++) {
            for(int j=0; j<rectangle[0].length; j++) {
                
                // x값 찾기
                if(j%2 == 0) {
                    int tmpX = rectangle[i][j];
                    if(maxX < tmpX) maxX = tmpX;
                }
                
                // y값 찾기
                if(j%2 == 1) {
                    int tmpY = rectangle[i][j];
                    if(maxY < tmpY) maxY = tmpY;
                }
            }
        }
        
        boolean[][] map = new boolean[(maxX*2)+2][(maxY*2)+2];
        
        // map 채우기
        for(int i=0; i<rectangle.length; i++) {
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;
            
            for(int x=x1; x<=x2; x++) {
                for(int y=y1; y<=y2; y++) {
                    map[x][y] = true;
                }
            }
        }
        
        // map 경계 안쪽 false로 바꾸기
        for(int i=0; i<rectangle.length; i++) {
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;
            
            for(int x=x1+1; x<x2; x++) {
                for(int y=y1+1; y<y2; y++) {
                    map[x][y] = false;
                }
            }
        }
        
        return map;
    }
    
   
}