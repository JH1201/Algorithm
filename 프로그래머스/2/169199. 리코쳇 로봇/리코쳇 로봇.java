import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        
        Queue<Node> q = new LinkedList<>();
        
        int startX = 0;
        int startY = 0;
        
        int endX = 0;
        int endY = 0;
        
        char[][] map = new char[board.length][board[0].length()];
        
        for(int i=0; i<board.length; i++) {
            String s = board[i];
            
            for(int j=0; j<s.length(); j++) {
                map[i][j] = s.charAt(j);
            }
        }
        
        for(int i=0; i<board.length; i++) {
            String s = board[i];
            
            for(int j=0; j<s.length(); j++) {
                if('R' == s.charAt(j)) {
                    startX = i;
                    startY = j;
                }
                
                else if('G' == s.charAt(j)) {
                    endX = i;
                    endY = j;
                }
            }
        }
        
        q.add(new Node(startX, startY, 0));
        
        while(!q.isEmpty()) {
            
            Node curNode = q.poll();
            
            int curX = curNode.getX();
            int curY = curNode.getY();
            int curCost = curNode.getCost();
            
            if(curX == endX && curY == endY)  {
                answer = curCost;
                break;
            }
            
            
            int[] xArr = {1, -1, 0, 0};
            int[] yArr = {0, 0, 1, -1};
            
            for(int i=0; i<4; i++) {
                
                int plusX = curX;
                int plusY = curY;
                
                while(true) {
                    int nextX = plusX + xArr[i];
                    int nextY = plusY + yArr[i];
                    
                    if(nextX < 0 || nextX >= board.length ||
                       nextY < 0 || nextY >= board[0].length()) {
                        break;
                    }

                    if(map[nextX][nextY] == 'D') {
                        break;
                    }

                    plusX = nextX;
                    plusY = nextY;
                }
                
                if(map[plusX][plusY] != 'A') {
                    q.add(new Node(plusX, plusY, curCost+1));
                    map[curX][curY] = 'A';
                }
            }
        }
        
        if(answer == 0) answer = -1;
        
        return answer;
    }
}

class Node {
    int x;
    int y;
    int cost;
    
    public Node(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getCost() {
        return this.cost;
    }
}