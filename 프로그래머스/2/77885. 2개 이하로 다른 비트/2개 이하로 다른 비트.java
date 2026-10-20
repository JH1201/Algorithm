import java.util.*;

class Solution {
    
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            answer[i] = getAnswer(numbers[i]);
        }
        
        return answer;
    }
    
    public long getAnswer(long n) {
        
        // 부호 비트 제외 오른쪽비트부터 왼쪽으로 순회하며 처음 나오는0을 찾고 그걸
        // 1로 바꾸고 바로 오른쪽에 있는 비트를 0으로 바꾸면 비트2개만 바꾸는 최솟값임 
        // 비트연산으로 (odd)에 한해서 0101 이라면 0110 이 되게끔 끼워맞추는 비트연산을 코딩하면됨
        
        if(n % 2 == 0) {
            return n+1;
        }
        else {
            long tmp = (~n) & (n+1);
            
            // 방법 1: 가장 오른쪽 0을 채우고(+tmp), 그 오른쪽 1을 제거한다(-(tmp >> 1))
            return n + tmp - (tmp >> 1); 
        }
    }
    
}