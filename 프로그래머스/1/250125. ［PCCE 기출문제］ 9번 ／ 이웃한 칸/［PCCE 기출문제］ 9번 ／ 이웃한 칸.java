class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String currentColore = board[h][w];
        
        int high = board.length;
        int width = board[0].length;
        
        //System.out.println("h: " + h + ", w: " + w);
        
        for(int i=h-1; i<=h+1; i++) {
            if(i>=high || i<0) {
                continue; 
            }
            for(int j=w-1; j<=w+1; j++) {
                if(j>=width || j<0) {
                    continue; 
                }
                
                
                
                if(board[i][j].equals(currentColore)) {
                    if((i == h && j == w) ||
                      (i-1 == h && j-1 == w) ||
                      (i-1 == h && j+1 == w) ||
                      (i+1 == h && j-1 == w) ||
                      (i+1 == h && j+1 == w)) continue;
                    
                    answer+=1;
                }
            }
        }
        
        
        
        return answer;
    }
}