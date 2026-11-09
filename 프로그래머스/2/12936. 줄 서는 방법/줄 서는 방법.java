import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        k--;
        
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            numbers.add(i);
        }
        
        // 3! -> 6
        // 4! -> 24
        
        int len = n;
        
        // 전체 갯수
        long total = n * factorial(n-1);
        
        while(list.size() != len) {
            int section = (int)(k / factorial(n-1));  
            
            // 시작하는 번호
            int startNm = numbers.remove(section);
            
            k = (k % factorial(n-1));

            list.add(startNm);
            //System.out.println("total: " + total + " / section: " + section + " / idx: " + idx);

            n -= 1;
            
        }
        
        
        for(int i=0; i<list.size(); i++) {
            //System.out.print(list.get(i) + " ");
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
    
    public long factorial(int num) {
        if(num == 0 || num == 1) return 1;
        return num * factorial(num-1);
    }
    
}