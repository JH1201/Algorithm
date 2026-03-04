class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int rightCnt = 1;
        int notRightCnt = 0;
        
        char firChar = s.charAt(0);
        for(int i=1; i<s.length(); i++) {
            if(rightCnt == 0) {
                firChar = s.charAt(i);
                rightCnt+=1;
                continue;
            }
            
            char c = s.charAt(i);
            
            if(firChar == c) rightCnt+=1;
            else notRightCnt+=1;
            
            if(rightCnt == notRightCnt) {
                //System.out.println(i);
                
                rightCnt = 0;
                notRightCnt = 0;
                answer+=1;
            }
        }
        
        if (rightCnt != 0) answer += 1;
        
        
        return answer;
    }
}