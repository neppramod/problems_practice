import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int[] height = {4,2,0,3,2,5};
		int result = sol.trap(height);
		System.out.println(result);
	}
	
	public int trap(int[] height) {
		if (height == null || height.length <= 1) {
			return 0;
		}

		int n = height.length;
		int[] left = new int[n];
		int[] right = new int[n];

		left[0] = height[0];


		int max = left[0];
		for (int i = 1; i < n; i++) {
			if (height[i] < max) {
				left[i] = max;
			} else {
				left[i] = height[i];
				max = left[i];
			}
		}

		right[n-1] = height[n-1];
		max = right[n-1];
		for (int i = n-2; i >= 0; i--) {
			if (height[i] < max) {
				right[i] = max;
			} else {
				right[i] = height[i];
				max = right[i];
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			result += Math.min(left[i], right[i]) - height[i];
		}

		return result;
	}
	
}
