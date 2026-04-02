class Solution {
    public int solution(String name) {
        int answer = 0;
        
        for(int i=0; i<name.length(); i++) {
            char target = name.charAt(i);
            
            int move = getMoveCont(target);
            //System.out.println(move);
            
            answer += move;
        }
        
        int len = name.length();
        int m = len - 1;  // 모든 문자가 A가 아니일 때
        
        for(int i=0; i<len; i++) {
            int next = i+1;
            
            while(next < len && name.charAt(next) == 'A') {
                next += 1;
            }
            
            // 오른쪽으로 갔다가 다시 i 위치로
            m = Math.min(m, i*2+(len-next));
                
            // 왼쪽으로 갔다가 다시 i 위치로
            m = Math.min(m, i + (len-next)*2);
        }
        
        
       
        return answer+m;
    }
    
    public int getMoveCont(char target) {
        int move = 0;
        
        System.out.println("target = " + (target-'A'));
        
        if(target-'A' > 13) {
            move = 'Z'- target+1;
        }
        else {
            move = target-'A';
        }
        
        return move;
    }
}