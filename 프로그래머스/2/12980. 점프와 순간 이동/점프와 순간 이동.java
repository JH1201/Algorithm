import java.util.*;

public class Solution {
    int ans = 0;
    
    public int solution(int n) {
        
        while(n > 0) {
            if(n % 2 == 0) {
                n /= 2;
            }
            else {
                n -= 1;
                ans++;
            }
        }
        
        
        return ans;
    }
    /*
    public void dfs(int n, int usage, int curLocate) {
        if(curLocate == n) {
            ans = Math.min(usage, ans);
            return ;
        }
        
        if(curLocate > n) return ;
        
        // 순간이동 할 때
        //dfs(n, usage, curLocate*2);
        
        // K칸 이동 및 순간이동
        for(int i=1; i<=n; i++) {
            dfs(n, usage+i, curLocate+i);
        }
        
        // 순간이동 할 때
        dfs(n, usage, curLocate*2);
    }
    */
}