import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                
                int tmp = 0;
                
                if (j == 0) {
                    tmp = triangle[i][0] + triangle[i-1][0];
                }
                else if(j == triangle[i].length-1) {
                    tmp = triangle[i][triangle[i].length-1] + triangle[i-1][triangle[i].length-2];
                }
                else {
                    int max = 0;
                    
                    // 왼쪽 위
                    int leftUpvalue = triangle[i][j] + triangle[i-1][j-1];
                    
                    // 오른쪽 위
                    int rightUpvalue = triangle[i][j] + triangle[i-1][j];
                    
                    if(leftUpvalue > rightUpvalue) {
                        tmp = leftUpvalue;
                    }
                    else {
                        tmp = rightUpvalue;
                    }
                }
                
                triangle[i][j] = tmp;
                
            }
        }
        
        int len = triangle.length-1;
        for(int j=0; j<triangle[len].length; j++) {
                
            //System.out.print(triangle[len][j] + " ");

            answer = Math.max(answer, triangle[len][j]);
        }
        
        
        return answer;
    }
}