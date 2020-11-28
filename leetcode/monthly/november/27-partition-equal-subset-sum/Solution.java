import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 5};
        boolean result = sol.canPartition(nums);
        System.out.println(result);
    }

    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return false;
       }

        int sum = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        boolean[][] dp = new boolean[sum/2 + 1][n+1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = true;
        }

        for (int i = 1; i <= sum/2; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1];

                if (i >= nums[j-1]) {
                    dp[i][j] |= dp[i-nums[j-1]][j-1]; 
                }
                
            }
        }

        return dp[sum/2][n];
    }

    
    /*
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

    */
}