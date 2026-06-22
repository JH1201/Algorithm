import java.util.*;

class Solution {    
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    ArrayList<Integer> res = new ArrayList<>();
    boolean[][] flag;
    
    public int[] solution(String[] maps) {
        
        flag = new boolean[maps.length][maps[0].length()];
        char[][] oceanMap = new char[maps.length][maps[0].length()];
        
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                oceanMap[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i=0; i<oceanMap.length; i++) {
            for(int j=0; j<oceanMap[i].length; j++) {
                if(!flag[i][j] && oceanMap[i][j] != 'X') {
                    int sum = DFS(oceanMap, i, j, 0);
                    res.add(sum);
                }
            }
        }
        
        if(res.isEmpty()) {
            return new int[] {-1};
        }
        
        Collections.sort(res);
        
        int[] answer = new int[res.size()];
        for (int k=0; k<res.size(); k++) {
            answer[k] = res.get(k);
        }
        
        return answer;
    }
    
    public int DFS(char[][] oceanMap, int i, int j, int sum) {
        
        // 배열 범위를 벗어나면 종료
        if(i < 0 || j < 0 || i >= oceanMap.length || j >= oceanMap[0].length) {
            return sum;
        }
        
        // 갈수 없거나 방문한 섬일 때
        if(flag[i][j] == true) {
            return sum;
        }
        
        // 바다이면 종료
        if(oceanMap[i][j] == 'X') {
            return sum;
        }
        
        // 방문하지 않은 섬일 때
        flag[i][j] = true;
        sum += oceanMap[i][j] - '0';
        
        for(int k=0; k<4; k++) {
            sum = DFS(oceanMap, i + dx[k], j + dy[k], sum);
        }
        
        return sum;
    }
}