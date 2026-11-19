import java.util.*;

class Solution {
    
    boolean[] v;
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 최소 신장 트리
        
        // 비용이 싼 순서로 정렬
        Arrays.sort(costs, (a, b) -> {
            return a[2] - b[2];        
        });
        
        // 부모 노드 초기화
        parent = new int[n];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        for(int[] cost : costs) {
            //System.out.println(cost[0] + ", " + cost[1] + ", " + cost[2]);
            
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];

            if(find(a) != find(b)) {
                union(a, b);
                answer += c;
            }
            
        }
        
        return answer;
    }
    
    public int find(int n) {
        if(parent[n] == n) return n;
        
        return parent[n] = find(parent[n]);
    }
    
    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        
        if(pa != pb) {
            parent[pb] = pa;
        }
        
    }
}