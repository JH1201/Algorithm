import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] arr = new int[number];
        
        for(int i=1; i<=number; i++) {
            int tmp = findNumber(i);
            arr[i-1] = tmp;
        }
        
        for(int t : arr) {
            if(t > limit) {
                answer += power;
            }
            else {
                answer += t;
            }
        }
        
        return answer;
    }
    
    public int findNumber(int n) {
        int cnt = 0;
        
        //ArrayList<Integer> list = new ArrayList<>(); 
        
        for(int i=1; i*i <= n; i++) {
            if(n%i == 0) {
                cnt++;
                //list.add(i);
                
                if(i != n/i) {
                    cnt++;
                    //list.add(n/i);
                }
            }
        }
        
        //Collections.sort(list);
        //System.out.println(list);
        
        return cnt;
    }
}