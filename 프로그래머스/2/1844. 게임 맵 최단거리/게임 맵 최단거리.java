import java.util.*;

class Solution {
    Queue<int []> queue = new LinkedList<>();
    boolean[][] visited = new boolean[100][100];
    
    int[] x = {1, -1, 0, 0};
    int[] y = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        
        bfs(maps, new int[]{0,0});
        
        if(visited[maps.length - 1][maps[0].length - 1]) {
            answer = maps[maps.length - 1][maps[0].length - 1];
        }
        
        return answer;
    }
    
    public void bfs(int[][] maps, int[] start) {
        
        queue.add(start);
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            
            // 방금 꺼낸 칸에서 동,서,남,북으로 갈 수 있는데를 queue에 넣기
            for(int i=0; i<4; i++) {
                int xIndex = tmp[0] + x[i];
                int yIndex = tmp[1] + y[i];
                
                // 벽 바깥으로 넘어갈 경우
                if(xIndex < 0 || xIndex >= maps.length || yIndex < 0 || yIndex >= maps[0].length) continue;
                // 방문한 경우 또는 벽인 경우
                if(visited[xIndex][yIndex] || maps[xIndex][yIndex] == 0) continue;
                
                visited[xIndex][yIndex] = true;
                queue.add(new int[]{xIndex, yIndex});
                maps[xIndex][yIndex] = maps[tmp[0]][tmp[1]] + 1;
                
            }


            // 
        }
    }
}