class Solution {
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        int len = computers.length;
        
        visited = new boolean[len];
        
        for(int i=0; i<len; i++) {
            if(!visited[i]) {
                answer++;
                dfs(computers, i);
            }
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, int currnetNode) {
        
        if(visited[currnetNode]) return;
        
        visited[currnetNode] = true;
        
        // 현재 노드에서 갈 수 있는 방향으로 dfs 실행
        for(int i=0; i<computers.length; i++) {
            if(i == currnetNode) continue;
            if(computers[i][currnetNode] == 1) {
                dfs(computers, i);
            }
        }
        
    }
    
}