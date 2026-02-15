class Solution {
    public int solution(String name) {
        int answer = 0;
        
        String tmp = "";
        int start = 0;
        int end = name.length();
        
        // 세로
        for(int i=0; i<name.length(); i++) {
            char c = name.charAt(i);
            
            int up = c - 'A';
            int down = 'Z' - c + 1;
            answer += Math.min(up, down);
        }
        
        // 가로
        int len = name.length();
        int move = len - 1; // 기본: 오른쪽으로만 쭉

        for (int i = 0; i < len; i++) {
            int next = i + 1;

            // i 다음부터 연속된 'A' 구간 스킵
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            // 케이스 1: 오른쪽 갔다가 되돌아오기
            move = Math.min(move, 2 * i + (len - next));

            // 케이스 2: 뒤쪽부터 먼저 갔다가 되돌아오기
            move = Math.min(move, i + 2 * (len - next));
        }
        
        return answer+move;
    }
}