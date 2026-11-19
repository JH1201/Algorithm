import java.util.*;

class Solution {
    
    boolean[] v;
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (a, b) -> {
            return a[2] - b[2];
        });
        
        parent = new int[n];
        
        // 부모 그룹 초기화
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
    
    // 부모 노드 찾기
    public int find(int a) {
        if(parent[a] == a) return a;
        return find(parent[a]);
    }
    
    // 같은 그룹으로 연결
    public void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        
        if(pA != pB) {
            parent[pA] = pB;
        }
        
    }
    

}