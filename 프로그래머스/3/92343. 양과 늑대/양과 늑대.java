import java.util.*;

class Solution {
    
    int answer = 0;
        
    public int solution(int[] info, int[][] edges) {
        
        Node[] node = new Node[info.length];
        
        for(int i=0; i<info.length; i++) {
            node[i] = new Node(i, info[i]);
        }
        
        for(int i=0; i<edges.length; i++) {
            
            int parent = edges[i][0];
            int child = edges[i][1];
            
            node[parent].setChildren(node[child]);
            
        }
        
        dfs(node[0], 0, 0, node[0].getChildren());
            
        return answer;
    }
    
    public void dfs(Node parent, int lambCnt, int wolfCnt, ArrayList<Node> childrenList) {
        
        if(parent.type == 0) {
            lambCnt++;
        }
        else {
            wolfCnt++;
        }
        
        if(lambCnt <= wolfCnt) {
            return;
        }
        
        answer = Math.max(answer, lambCnt);
        
        for (int i = 0; i < childrenList.size(); i++) {

            Node next = childrenList.get(i);

            ArrayList<Node> nextChildrenList = new ArrayList<>(childrenList);

            // next는 이번에 방문하므로 후보에서 제거
            nextChildrenList.remove(i);

            // next의 자식들을 새로운 후보에 추가
            ArrayList<Node> nnC = next.getChildren();
            
            for(Node n : nnC) {
                nextChildrenList.add(n);
            }
            
            dfs(next, lambCnt, wolfCnt, nextChildrenList);
        }
        
    }
}

class Node {
    int nodeNum;
    int type;
    
    ArrayList<Node> children = new ArrayList<>();
    
    public Node(int n, int type) {
        this.nodeNum = n;
        this.type = type;
    }
    
    public ArrayList<Node> getChildren() {
        return this.children;
    }
    
    public void setChildren(Node c) {
        children.add(c);
    }
}
