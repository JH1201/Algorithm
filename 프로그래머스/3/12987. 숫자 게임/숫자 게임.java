import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        // A 출전 순서 배열
        // B ex) 첫번째 원소 B[1] -> i=1번이 가지는 수
        
        //if(getMax(A) > getMax(B)) return 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        /*
        Queue<Integer> aQ = new LinkedList<>();
        Queue<Integer> bQ = new LinkedList<>();
        
        for(int i : A) {
            aQ.offer(i);
        }
        
        for(int i : B) {
            bQ.offer(i);
        }
        
        int idx = 0;
        int flag = 0;
        
        while(!bQ.isEmpty() && idx < A.length) {
            int bTmp = bQ.poll();
            int aNm = A[idx];
            
            if(bTmp > aNm) {
                idx++;
                answer++;
            }
            else {
                if(flag > A.length*2) break;
                flag++;
                bQ.offer(bTmp);
            }
            
        }
        */
        
        int aIdx = 0;
        int bIdx = 0;
        
        while(bIdx < B.length && aIdx < A.length) {
            
            int aNm = A[aIdx];  
            int bNm = B[bIdx];  
            
            if(aNm < bNm) {
                aIdx++;
                bIdx++;
                answer++;
                continue;
            }
            else {
                bIdx++;
            }
        }
        
        
        return answer;
    }
    
    public int getMax(int[] arr) {
        int tmp = 0;
        
        for(int i : arr) {
            if(tmp < i) tmp = i;
        }
        
        return tmp;
    }
}