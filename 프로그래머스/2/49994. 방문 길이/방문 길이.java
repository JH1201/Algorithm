import java.util.*;

class Solution {
    
    int answer = 0;
    boolean[][] map = new boolean[121][121];    
    
    public int solution(String dirs) {
        
        Node curLoc = new Node(0, 0, 0);
        //ArrayList<Node> firList = new ArrayList<>();
        //firList.add(curLoc);
        //curLoc.setList(firList);
        
        HashMap<Node, Boolean> visited = new HashMap<>();
        
        for(int i=0; i<dirs.length(); i++) {
            
            char c = dirs.charAt(i);
            String nextDirection = String.valueOf(c);
            
            Node nextNode = getNextNode(curLoc, nextDirection);
                
            curLoc = nextNode;
            
        }
        
        return answer = curLoc.getCnt();
    }
    
    public Node getNextNode(Node curNode, String nD) {
        //String nD = curNode.getNextDirection();
        
        int nextX = curNode.getX();
        int nextY = curNode.getY();
        
        switch(nD) {
            case "U" :
                nextY += 1;
                break;
            case "D" :
                nextY -= 1;
                break;
            case "R" :
                nextX += 1;
                break;
            case "L" :
                nextX -= 1;
                break;
        }
        
        // map 범위를 벗어났을 땐 가만히 있기
        if(nextX > 5 || nextX < -5 || nextY > 5 || nextY < -5) {
            return curNode;
        }
        
        int curX = curNode.getX();
        int curY = curNode.getY();
        int curCnt = curNode.getCnt();
        
        Node nextNode = new Node(nextX, nextY, curCnt);
        //nextNode.setList();
        
        // 현재 노드와 다음 노드 지나간 길 체크
        if(checkLinked(curNode, nextNode)) {
            //System.out.println("curNode: " + curNode.getX() + ", " + curNode.getY() + ", " + nD);
            //System.out.println("nextNode: " + nextNode.getX() + ", " + nextNode.getY() + ", " + nD);
            return nextNode;
        }
        // 안 지나간 길이라면
        else {
            
            //System.out.println("X curNode: " + curNode.getX() + ", " + curNode.getY() + ", " + nD);
            
            // 두 개의 노드 연결
            linkNode(curNode, nextNode);
            
            nextNode.setCnt(curCnt+1);
            
            return nextNode;
        }
    }
    
    public void linkNode(Node cur, Node next) {
        int curX = cur.getX() + 5;
        int curY = cur.getY() + 5;
        int nextX = next.getX() + 5;
        int nextY = next.getY() + 5;
        
        int curNum = curX * 11 + curY;
        int nextNum = nextX * 11 + nextY;
        
        map[curNum][nextNum] = true;
        map[nextNum][curNum] = true;
        
    }
    
    public boolean checkLinked(Node cur, Node next) {
        int curX = cur.getX() + 5;
        int curY = cur.getY() + 5;
        int nextX = next.getX() + 5;
        int nextY = next.getY() + 5;
        
        int curNum = curX * 11 + curY;
        int nextNum = nextX * 11 + nextY;
        
        if(map[curNum][nextNum] == true && map[nextNum][curNum] == true) return true;
        else return false;
    }
    
    
    class Node {
        int x;
        int y;
        int cnt;
        ArrayList<Node> linkedList = new ArrayList<>();
        
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
        
        public void setX(int x) {
            this.x = x;
        }
        
        public void setY(int y) {
            this.y = y;
        }
        
        public int getCnt() {
            return this.cnt;
        }
        
        public void setCnt(int c) {
            this.cnt = c;
        }
        
        public ArrayList<Node> getList() {
            return this.linkedList;
        }
        
        public void setList(ArrayList<Node> list) {
            this.linkedList = list;
        }
        
    }
}