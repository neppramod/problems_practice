import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int[] nums = {1, 2, 3, 4};
		int[] result = sol.productExceptSelf(nums);
		System.out.println(Arrays.toString(result));
	}
	
	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return new int[] {};
		}

		int n = nums.length;
		
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = 1;
		right[n-1] = 1;

		for (int i = 0; i < n-1; i++) {
			left[i+1] = left[i] * nums[i];
		}

		for (int i = n-1; i > 0; i--) {
			right[i-1] = right[i] * nums[i];
		}

		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			result[i] = left[i] * right[i];
		}

		return result;
	}
	
}
