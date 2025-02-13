class Solution {
    public int solution(int n) {
        int answer = 0;
        String temp = "";
        while(true) {
            temp += Integer.toString(n%3);
            n = n / 3;
            
            if(n == 0) break;
        }
        
        StringBuffer sb = new StringBuffer(temp); 
        String reverse = sb.reverse().toString();
       
        int res = 1;
        for(int i=0; i<reverse.length(); i++) {
            int num =reverse.charAt(i) -'0';
            if(i==0) 
            {
                res = 1;
                answer += res*num;
                continue;
            }
            
            for(int j=1; j<=i; j++) {
                res *= 3;
            }
            
            
            answer += res * (num);
            res = 1;
        }
        
        
        
        
        
        
        return answer;
    }
}