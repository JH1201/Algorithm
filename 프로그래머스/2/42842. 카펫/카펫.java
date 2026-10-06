class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        int min = 3;
        int max = sum/3;
        
        for(int i=min; i<=max; i++) {
            for(int j=min; j<=max; j++) {
                if(i*j == sum && i>=j && (i-2) * (j-2) == yellow) {
                    answer[0] = i;
                    answer[1] = j;
                    
                    return answer;
                }
            }
        }
        
        return answer;
    }
}