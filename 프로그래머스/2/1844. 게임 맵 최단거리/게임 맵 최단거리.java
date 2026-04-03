import java.util.*;

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

class Solution {
    Queue<Node> queue = new LinkedList<>();
    boolean[][] visited = new  boolean[100][100];
    
    public int solution(int[][] maps) {
        int answer = -1;
      
        
        Node start = new Node(0,0,1);
        queue.offer(start);
        //visited[start.x][start.y] = true;
        
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            if(visited[current.x][current.y]) continue;
            visited[current.x][current.y] = true;
            
            //System.out.println("x = " + current.x + ", y = " + current.y);
            
            if(current.x == maps.length-1 && current.y == maps[0].length-1) {
                answer = current.cost;
                break;
            }
            
            for(int i=0; i<4; i++) {
                int nx = dx[i] + current.x;
                int ny = dy[i] + current.y;
            
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) {
                    continue;
                }
                if(maps[nx][ny] == 1) {
                    queue.offer(new Node(nx, ny, current.cost+1));
                }
            }
        }
        
        return answer;
    }
}