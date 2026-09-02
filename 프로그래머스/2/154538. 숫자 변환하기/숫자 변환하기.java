import java.util.*;

class Solution {
    
    boolean[] visited = new boolean[1000001];
    
    public int solution(int x, int y, int n) {
        
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{x, 0});
        visited[x] = true;
        
        while(!q.isEmpty()) {
            
            int[] tmp = q.poll();
            
            int curDepth = tmp[1];
            
            if(tmp[0] == y) {
                return curDepth;
            }
            
            int firOP = tmp[0] + n;
            int secOP = tmp[0] * 2;
            int thrOP = tmp[0] * 3;
            
            //System.out.println("firOP: " + firOP + ", secOP: " + secOP + ", thrOP: " + thrOP + " / answer: " + answer);
            
            
            if(firOP <= y && !visited[firOP]) {
                visited[firOP] = true;
                q.add(new int[]{firOP, curDepth+1});
            }
            if(secOP <= y && !visited[secOP]) {
                visited[secOP] = true;
                q.add(new int[]{secOP, curDepth+1});
            }
            if(thrOP <= y && !visited[thrOP]) {
                visited[thrOP] = true;
                q.add(new int[]{thrOP, curDepth+1});
            }
            
        }
        
        return -1;
    }
    
    
    /*
    // dfs 방식은 필요없는 계산이 너무 많음
    public void dfs(int x, int y, int n, int sum, int depth) {
        
        //System.out.println("depth: " + depth + " / dfs start / a: " + a + ", sum: " +sum);
        
        if(sum == y) {
            if(answer > depth) answer = depth;
            
            //System.out.println("sum == y" + " / answer: " + answer + ", sum: " +sum);
            return ; 
        }
        
        else if(sum > y) {
            //System.out.println("sum > y" + " / answer: " + answer + ", sum: " +sum);
            return;
        }
        
        
        
        dfs(x, y, n, sum+n, depth+1);
        dfs(x, y, n, sum*2, depth+1);
        dfs(x, y, n, sum*3, depth+1);
        
    }
    */
}