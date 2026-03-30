class Solution {
    
    static int count = 0;
    //static int sum = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        System.out.println(count);
        return count;
    }
    
    public void dfs(int[] numbers, int target, int sum, int index) {
        if(index == numbers.length) {
            if(sum == target) count++;
            return;
        }
        
        dfs(numbers, target, sum+numbers[index], index+1);
        dfs(numbers, target, sum-numbers[index], index+1);
    }
    
}