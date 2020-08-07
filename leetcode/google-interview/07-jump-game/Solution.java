import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
		int[] nums = {2, 3, 1, 1, 4};
		Solution sol = new Solution();
		boolean result = sol.canJump(nums);
		System.out.println(result);
    }
    
	public boolean canJump(int[] nums) {
        int n = nums.length;
		boolean[] dp = new boolean[n];
		dp[0] = true;

		for (int i = 0; i < nums.length; i++) {
			if (dp[i] == true) {
				for (int j = i; j <= i + nums[i]; j++) {
					if (j < n && !dp[j]) {
						dp[j] = true;
					}
				}				
			}
		}

		return dp[n-1];
    }
}
