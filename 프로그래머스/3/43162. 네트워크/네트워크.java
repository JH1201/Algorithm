class Solution {
    static int answer = 0;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        
        // 방문한 컴퓨터의 번호
        visited = new boolean[computers.length];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i, computers);
            }
        }
        
        return answer;
    }
    
    public void dfs(int num, int[][] computers) {
        // 컴퓨터 방문 확인
        // visited = true
        if(visited[num]) return;
        if(!visited[num]) visited[num] = true;
        System.out.println("현재 컴퓨터 넘버 : " + (num+1) + " / 방문 여부 : " + visited[num]);
        
        // 연결 확인
        // 연결된 컴퓨터 방문 visited = true
        for(int i=0; i<computers.length; i++) {
            if(!visited[i] && computers[num][i] == 1) dfs(i, computers);
        }
        
        
    }
    
}