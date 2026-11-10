class Solution {
    public int solution(String name) {
        int answer = 0;
        
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
        // a b c d e f g h i j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
        
        // 위아래 카운트
        for(int i=0; i<name.length(); i++) {
            char c = name.charAt(i);
            int tmp = c - 'A';
            
            if(tmp <= 13) answer += c - 'A';
            else answer += 'Z' - c + 1;
            
        }
        
        // 좌우 카운트
        int min = 20;
        for(int i=0; i<name.length(); i++) {
            
            int next = i+1;
            while(next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            
            
            // 현재 위치에서 다음 목표(next)까지 오른쪽으로 갔을 때
            min = Math.min(min, i*2 + name.length()-next);
            
            // 현재 위치에서 다음 목표(next)까지 왼쪽으로 갔을 때
            min = Math.min(min, (name.length()-next) * 2 + i);
        }
        
        return answer + min;
    }
   
}