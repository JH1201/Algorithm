import java.util.*;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        
        int A = 0;
        int B = 0;
        if(a < b) {
            A = a;
            B = b;
        }
        else {
            A = b;
            B = a;
        }

        int mid = n/2;
        int start = 1;
        int end = n;
        
        while(n != 1) {
            // A <= mid < B
            if(A <= mid && mid < B) {
                n = n/2;
                answer++;
            }
        
            else {
                
                if(B <= mid) end = mid;
                else if(A > mid) start = mid+1;

                mid = (start + end) / 2;
                n = n/2;
            }
            
            //System.out.println("A: " + A + ", B: " + B + ", mid: " + mid + ", answerr: " + answer);
        }
        
        
        
        
        return answer;
    }
}