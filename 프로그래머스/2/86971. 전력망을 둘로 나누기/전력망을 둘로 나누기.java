import java.util.*;

class Node {
    int start;
    int to;
    
    Node(int start, int to) {
        this.start = start;
        this.to = to;
    }
}

class Solution {
    
    public int solution(int n, int[][] wires) {
        int answer = 100;

        for(int i=0; i<wires.length; i++) {
            int res = findCount(n, wires, i);
            
            answer = Math.min(answer, res);
        }
        
        return answer;
    }
    
    public int findCount(int n, int[][] wires, int i) {
        boolean[] v = new boolean[n];
        
        int n1 = wires[i][0];
        int n2 = wires[i][1];
        
        wires[i][0] = 0;
        wires[i][1] = 1;
        
        int a = dfs(n1, wires, v, 1);
        
        for(int j=0; j<v.length; j++) {
            v[j] = false;
        }
        
        int b = dfs(n2, wires, v, 1);
        
        wires[i][0] = n1;
        wires[i][1] = n2;
        
        //System.out.println("a: " + a + ", b: " + b);
        
        return Math.abs(a-b);
    }
    
    public int dfs(int sNum, int[][] wires, boolean[] v, int cnt) {
        
        if(sNum == 0 || v[sNum-1] == true) return 0; 
        
        v[sNum-1] = true;
        
        int r = 1;
        for(int i=0; i<wires.length; i++) {
            
            // 정방향
            if(sNum == wires[i][0]) {
                r += dfs(wires[i][1], wires, v, cnt++);
            }
            
            // 역방향
            if(sNum == wires[i][1]) {
                r += dfs(wires[i][0], wires, v, cnt++);
            }
        }
        
        return r;
    }
    
    
}