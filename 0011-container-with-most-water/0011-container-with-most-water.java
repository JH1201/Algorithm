import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        
        int start = 0;
        int end = height.length-1;

        int sum = 0;
        while(start < end) {
            int w = end - start;
            int h = Math.min(height[start], height[end]);

            if(sum < w*h) sum = w*h;

            if(height[start] <= height[end]) start++;
            else end--;
        }

        return sum;
    }
}