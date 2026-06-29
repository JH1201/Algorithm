import java.util.*;

class Node {
    int cur;
    ArrayList<Integer> next = new ArrayList<>();
    int len;
    
    Node(int cur, ArrayList<Integer> next, int len) {
        this.cur = cur;
        this.next = next;
        this.len = len;
    }
    
    public int getCur() {
        return cur;
    }

    public void setCur(int cur) {
        this.cur = cur;
    }

    public ArrayList<Integer> getNextNodeList() {
        return next;
    }

    public void setNextNodeList(ArrayList<Integer> next) {
        this.next = next;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }
}

class Solution {
    
    Queue<Node> s = new LinkedList<>();
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 각 노드별로 연결된 그래프를 저장하는 변수 생성
        ArrayList<Node> nodeList = new ArrayList<>();
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0; i<edge.length; i++) {
            int nodeNum = edge[i][0];
            int nextNum = edge[i][1];
            
            if(map.get(nodeNum) == null) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(nextNum);
                map.put(nodeNum, tmp);
            }
            else {
                ArrayList<Integer> tmp = map.get(nodeNum);
                tmp.add(nextNum);
                map.put(nodeNum, tmp);
            }
            
             // 반대 방향도 저장
            if(map.get(nextNum) == null) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(nodeNum);
                map.put(nextNum, tmp);
            }
            else {
                ArrayList<Integer> tmp = map.get(nextNum);
                tmp.add(nodeNum);
                map.put(nextNum, tmp);
            }
        }
        
        for(int i=0; i<=n; i++) {
            Node tmpNode = new Node(i, map.get(i), 0);
            nodeList.add(tmpNode);
        }
        
        Boolean[] visited = new Boolean[n+1];
        Arrays.fill(visited, false);
        visited[1] = true;
        
        // 첫 번째 노드 삽입
        s.add(nodeList.get(1));
        BFS(1, visited, nodeList);
        
        int max = 0;
        
        for(int i=1; i<nodeList.size(); i++) {
            //System.out.println("nodeList " + i + ": " + nodeList.get(i).getLen());
            if(max < nodeList.get(i).getLen()) max = nodeList.get(i).getLen();
        }
        
        //System.out.println("max = " + max);
        
        for(int i=1; i<nodeList.size(); i++) {
            if(max == nodeList.get(i).getLen()) answer++;
        }
        
        return answer;
    }
    
    public void BFS(int idx, Boolean[] visited, ArrayList<Node> nodeList) {
        
        while(!s.isEmpty()) {
            Node cur = s.poll();
            
            for(int i=0; i<cur.getNextNodeList().size(); i++) {
                int nextNodeNum = cur.getNextNodeList().get(i);
                
                if(visited[nextNodeNum] == false) {
                    visited[nextNodeNum] = true;
                    nodeList.get(nextNodeNum).setLen(cur.getLen()+1);
                    s.add(nodeList.get(nextNodeNum));
                }
            }
        }
        
    }
}