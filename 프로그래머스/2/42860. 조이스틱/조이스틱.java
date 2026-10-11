class Solution {
    public int solution(String name) {
        int answer = 0;
        
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
        // a b c d e f g h i j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
       
        for(int i=0; i<name.length(); i++) {
            char c = name.charAt(i);
            
            int tmp = c - 'A';
                
            if(tmp <= 13) {
                answer += c - 'A';

            } 
            else {
                answer += 'Z' - c + 1;
            }
        }
        
        int len = name.length();
        int m = len - 1;  // 모든 문자가 A가 아니일 때
        
        for(int i=0; i<len; i++) {
            
            int next = i+1;
            while(next < len && name.charAt(next) == 'A') {
                next++;
            }
            
            // 현재 위치에서 오른쪽으로 next까지 
            // i*2 -> 시작점 0부터 i까지 거리를 갔다 오는 값
            m = Math.min(m, i*2+(len-next));
            
            // 현재 위치에서 왼쪽으로 0까지 갔다가 next까지 
            // (len-next) * 2 -> name 왼쪽 마지막에서 next까지 갔다 돌아오는 값
            m = Math.min(m, i + (len-next) * 2);
            
        }
        
        return answer+m;
    }
   
}