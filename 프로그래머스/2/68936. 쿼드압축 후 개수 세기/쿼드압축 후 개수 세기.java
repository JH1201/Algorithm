import java.util.*;

class Solution {
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        
        
        getAnswer(arr);
        
        return answer;
    }
    
    public void getAnswer(int[][] arr) {
        
        boolean flag = true;
        int tmp = arr[0][0];
        
        // 전체 다 같은 숫자인지 확인
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                if(tmp != arr[i][j]) {
                    flag = false;
                    break;
                }
            }
        }
        
        // 다 같은 숫자라면 해당 숫자 카운드 증가
        if(flag) answer[tmp] += 1;
        
        // 아니라면 4등분 해서 배열 넘기기
        else {
            
            int len = arr.length/2;
            
            int[][] fristArr = new int[len][len];
            int[][] sectArr = new int[len][len];
            int[][] thrArr = new int[len][len];
            int[][] fourArr = new int[len][len];
            
            for(int i=0; i<len; i++) {
                for(int j=0; j<len; j++) {
                    fristArr[i][j] = arr[i][j];
                }
            }
            
            for(int i=len; i<arr.length; i++) {
                for(int j=0; j<len; j++) {
                    sectArr[i-len][j] = arr[i][j];
                }
            }
            
            for(int i=0; i<len; i++) {
                for(int j=len; j<arr.length; j++) {
                    thrArr[i][j-len] = arr[i][j];
                }
            }
            
            for(int i=len; i<arr.length; i++) {
                for(int j=len; j<arr.length; j++) {
                    fourArr[i-len][j-len] = arr[i][j];
                }
            }
            
            getAnswer(fristArr);
            getAnswer(sectArr);
            getAnswer(thrArr);
            getAnswer(fourArr);
            
        }
    }
}