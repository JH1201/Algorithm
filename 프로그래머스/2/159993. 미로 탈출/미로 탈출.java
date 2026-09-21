import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        
        Node start = new Node(0,0,0);
        Node lever = new Node(0,0,0);
        Node end = new Node(0,0,0);
        
        String[] copyMaps = new String[maps.length];
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                
                if(maps[i].charAt(j) == 'S') {
                    start.setX(i);
                    start.setY(j);
                    start.setT('S');
                }
                
                else if(maps[i].charAt(j) == 'L') {
                    lever.setX(i);
                    lever.setY(j);
                    lever.setT('L');
                }
                
                else if(maps[i].charAt(j) == 'E') {
                    end.setX(i);
                    end.setY(j);
                    end.setT('E');
                }
            }
            
            copyMaps[i] = maps[i]; 
        }
        
        
        int toLever = bfs(start, lever, maps);
        int toExit = bfs(lever, end, copyMaps);
        
        //System.out.println("toLever: " + toLever + ", toExit: " + toExit);
        
        answer = toLever + toExit;
        
        if(toLever == 0 || toExit == 0) answer = -1;
        
        return answer;
    }
    
    public int bfs(Node s, Node target, String[] maps) {
        
        Queue<Node> q = new LinkedList<>();
        
        int res = 0;
        
        q.add(s);
        
        while(!q.isEmpty()) {
            
            Node curNode = q.poll();
            
            if(curNode.getT() == target.getT()) {
                res = curNode.getCost();
                break;
            }
            
            if(maps[curNode.getX()].charAt(curNode.getY()) == 'X') {
                continue;
            }
            
            // 방문처리
            StringBuilder sb = new StringBuilder(maps[curNode.getX()]);
            sb.setCharAt(curNode.getY(), 'X');
            
            maps[curNode.getX()] = sb.toString();
            
            int[] x = {1, -1, 0, 0};
            int[] y = {0, 0, -1, 1};
            
            for(int i=0; i<4; i++) {
                int dx = x[i] + curNode.getX();
                int dy = y[i] + curNode.getY();
                
                if(dx < 0 || dx >= maps.length || dy < 0 || dy >= maps[0].length()) continue;
                if(maps[dx].charAt(dy) == 'X') continue;
                
                Node nextNode = new Node(dx, dy, curNode.getCost()+1);
                nextNode.setT(maps[dx].charAt(dy));
                
                q.add(nextNode);
                
                
            }
        }
        
        return res;
    }
}

class Node {
    int x;
    int y; 
    char t;
    int cost;
    
    public Node(int x, int y, int c) {
        this.x = x;
        this.y = y;
        this.cost = c;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public char getT() {
        return this.t;
    }
    
    public int getCost() {
        return this.cost;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setT(char T) {
        this.t = T;
    }
    
    public void setCost(int c) {
        this.cost = c;
    }
    
} 