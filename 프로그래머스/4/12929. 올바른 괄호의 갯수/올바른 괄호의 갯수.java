import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int n) {
        
        dfs(n, 0, 0);
        
        return answer;
    }
    
    public void dfs(int n, int openCnt, int closeCnt) {
        
        if(openCnt > n || closeCnt > n) return;
        if(closeCnt > openCnt) return;
        if(openCnt == closeCnt) {
            if(n == openCnt && n == closeCnt) {
                answer++;
                return ;   
            }
        }
        
        dfs(n, openCnt+1, closeCnt);
        dfs(n, openCnt, closeCnt+1);
    }
}