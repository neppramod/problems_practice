import java.util.*;



class Solution {
	   public static void main(String[] args) {
	    Solution sol = new Solution();
		
	}

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        if (heights.length == 1) {
            return heights[0];
        }
        
        int largest = 0;
        int n = heights.length;
        int i = 0, j = n - 1;
        
        while (i < j) {
            largest = Math.max(largest, Math.min(heights[i], heights[j]) * (j - i));
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        
        return largest;
    }
}
