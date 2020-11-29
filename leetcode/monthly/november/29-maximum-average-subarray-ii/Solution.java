import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int[] nums = { -1 };
		int k = 1;
		double result = sol.findMaxAverage(nums, k);
		System.out.println(result);
	}
	
    public double findMaxAverage(int[] nums, int k) {

		if (nums == null || nums.length < k) {
			return 0;
		}
		
		int n = nums.length;
		int[] dp = new int[n+1];  // cummulative sum

		dp[0] = 0;
		
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] + nums[i-1];
		}

		double max = Integer.MIN_VALUE;
		
		for (int m = k; m <= n; m++) {
			for (int i = 0; i <= n - m; i++) {
				max = Math.max(max, (double) (dp[i + m] - dp[i]) / (double) m);
			}
		}

		return max;
    }
}
