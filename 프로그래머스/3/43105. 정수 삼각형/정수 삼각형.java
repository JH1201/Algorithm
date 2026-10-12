import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<=i; j++) {
                
                int leftValue = 0;
                int rightValue = 0;
                
                
                // 오른쪽 값이 없을 때
                if(j == i) {
                    leftValue = getLeftValue(i ,j, triangle);
                    triangle[i][j] = leftValue + triangle[i][j];
                    continue;
                }
                
                // 왼쪽 값이 없을 때
                else if(j == 0) {
                    rightValue = getRigthValue(i ,j, triangle);
                    triangle[i][j] = rightValue + triangle[i][j];
                    continue;
                }
                
                else {
                    
                    int tmp = triangle[i][j];
                    
                    leftValue = getLeftValue(i, j, triangle);
                    tmp = Math.max(leftValue+triangle[i][j], triangle[i][j]);
                    
                    rightValue = getRigthValue(i, j, triangle);
                    triangle[i][j] = Math.max(rightValue+triangle[i][j], tmp); 
                }
            }   
        }
        
        for(int j=0; j<triangle[triangle.length-1].length; j++) {
            answer = Math.max(answer, triangle[triangle.length-1][j]);
        }   
        
        /*
        for(int[] arr : triangle) {
            for(int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        */
        
        return answer;
    }
    
    public int getLeftValue(int i, int j, int[][] triangle) {
        return triangle[i-1][j-1];
    }
    
    public int getRigthValue(int i, int j, int[][] triangle) {
        return triangle[i-1][j];
    }
}