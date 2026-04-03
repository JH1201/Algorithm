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
    
    PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.cost - b.cost);
    
    boolean[][] visited;
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    Node answerNode;
    int maxX = 0;
    int maxY = 0;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        boolean[][] boundary = getBoundary(rectangle);
        
        /*
        for(int i=0; i<boundary.length; i++) {
            for(int j=0; j<boundary[i].length; j++) {
                
                System.out.print(boundary[i][j] + " | ");
            }
            System.out.println();
        }
        */
        
        visited = new boolean[maxX * 2 + 1][maxY * 2 + 1];
        
        Node curLocation = new Node(characterX*2, characterY*2, 0);
        
        // 현재 위치 푸시
        q.offer(curLocation);
        visited[characterX*2][characterY*2] = true;
        
        bfs(boundary, itemX * 2, itemY * 2);
        
        int answer = answerNode.cost / 2;
        //System.out.println("X = " + answerNode.x + ", Y = " + answerNode.y + ", cost : " + answerNode.cost);
        
        
        return answer;
    }
    
    public void bfs(boolean[][] boundary, int itemX, int itemY) {
        
        while(!q.isEmpty()) {
            
            Node curLoc = q.poll();
            
            // 목표 좌표일 때 탈출
            if(curLoc.x == itemX && curLoc.y == itemY) {
                answerNode = new Node(curLoc.x, curLoc.y, curLoc.cost);
                break;
            }
            
            // curLoc가 테두리에 있는지 확인
            if(!checkBoundary(curLoc, boundary)) continue;
            
            int cost = curLoc.cost;
            
            //System.out.println("----------------------------------------------------");
            //System.out.println("curLocX = " + curLoc.x + ", curLocY = " + curLoc.y);
            
            // 테두리 위에서 curLoc가 갈 수 있는 좌표 확인
            for (int d = 0; d < 4; d++) {
                int nx = curLoc.x + dx[d];
                int ny = curLoc.y + dy[d];
                

                if (nx >= 0 && ny >= 0 && nx < boundary.length && ny < boundary[0].length && !visited[nx][ny] && boundary[nx][ny]) {
                    q.offer(new Node(nx, ny, cost+1));
                    visited[nx][ny] = true;
                }
            }
            
        }
    }
    
    boolean checkBoundary(Node n, boolean[][] boundary) {
        
        if (n.x < 0 || n.y < 0 || n.x >= boundary.length || n.y >= boundary[0].length) {
            return false;
        }
        return boundary[n.x][n.y];
    }
    
    public boolean[][] getBoundary(int[][] rectangle) {
        boolean[][] totalMap;
        
        for(int [] r : rectangle) {
            maxX = Math.max(maxX, r[2]);
            maxY = Math.max(maxY, r[3]);
        }
        
        totalMap = new boolean[maxX*2+1][maxY*2+1];
        
        for(int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for(int x=x1; x<=x2; x++) {
                for(int y=y1; y<=y2; y++){
                    totalMap[x][y] = true;
                }
            }
        }
        
        // 2. 내부는 false로 지움
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    totalMap[x][y] = false;
                }
            }
        }
        
        return totalMap;
    }
    
   
}