class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int area = brown + yellow;
        
        // 가로, 세로 최소 최대값
        int min = 3;
        int max = area/3;
        
        for(int w=min; w<=max; w++) {
            for(int h=min; h<=max; h++) {
                if((w>=h) && (w*h == area) && ((w-2)*(h-2) == yellow)) {
                    answer[0] = w;
                    answer[1] = h;
                    return answer;
                }
            }
        }
    
        return answer;
    }
}