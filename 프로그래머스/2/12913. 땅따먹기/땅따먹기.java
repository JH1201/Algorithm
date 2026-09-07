import java.util.*;

class Solution {
    
    int solution(int[][] land) {
        
        int answer = 0;
    
        for(int i=1; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                
                int max = 0;
                
                for(int pre=0; pre<4; pre++) {
                    if(pre == j) continue;
                    
                    max = Math.max(max, land[i-1][pre]);
                }
                
                land[i][j] += max;
            }
        }
        
        for(int i=0; i<4; i++) {
            answer = Math.max(answer, land[land.length-1][i]);
        }

        return answer;
    }
    
    
    /*
    // 시간 초과 발생
    // DP (동적계획법으로 풀어야 됨)
    public void dfs(int preCol, int[][] arr, int dep, int idx, int sum, int target) {
        if(dep > target) {
            if(answer < sum) answer = sum;
            return;
        }
        
        
        for(int i =0; i<4; i++) {
            if(preCol == i) continue;
            
            //System.out.println("preCol: "+ preCol + ", dep: " + dep + ", idx: " + idx + ", sum: " + sum);
            dfs(i, arr, dep+1, i, sum+arr[dep-1][i], target);
        }
        
    }
    */
    
}
