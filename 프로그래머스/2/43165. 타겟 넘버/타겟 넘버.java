class Solution {
    
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        
        
        dfs(0, numbers, 0, target);
      
        return count;
    }
    
    public void dfs(int idx, int[] numbers, int sum, int target) {
        
        if(idx >= numbers.length) {
            if(sum == target) {
                count++;
                
            }
            return;
        } 
        
        dfs(idx+1, numbers, sum + numbers[idx], target);
        
        dfs(idx+1, numbers, sum - numbers[idx], target);
    }
    
    
}