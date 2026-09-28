import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int aNum = findNumber(arrayA);
        int bNum = findNumber(arrayB);
        
        //System.out.println("aNum: " + aNum + ", bNum: " + bNum);
        
        if(checkAnser(aNum, arrayB)) answer = Math.max(answer, aNum);
        if(checkAnser(bNum, arrayA)) answer = Math.max(answer, bNum);
        
        return answer;
    }
    
    public boolean checkAnser(int n, int[] arr) {
        
        boolean flag = true;
        for(int a : arr) {
            if(a % n == 0) {
                flag = false;
                break;
            }
        }
        
        return flag;
    }
    
    public int findNumber(int[] array) {
        
        int max = 0;
        int cnt = 0;
        int res = 0;
        
        for(int i=0; i<array.length; i++) {
            if(array[i] > max) max = array[i];
        }
        
        for(int i=1; i<=max; i++) {
            for(int n : array) {
                if(n % i == 0) {
                    cnt++;
                    continue;
                }
                else break;
            }
            
            if(cnt == array.length) res = Math.max(res, i);
            cnt = 0;
        }
        
        return res;
    }
}