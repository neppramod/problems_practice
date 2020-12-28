import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int[] arr = { 1, 0, 2 };
		int result = sol.candy(arr);
		System.out.println(result);
	}

	
	
    public int candy(int[] ratings) {

		if (ratings == null || ratings.length == 0) {
			return 0;
			
		}

		int n = ratings.length;
		int[] left = new int[n];
		int[] right = new int[n];

		left[0] = 1;
		for (int i = 1; i < n; i++) {
			if (ratings[i-1] < ratings[i]) {
				left[i] = left[i-1] + 1;
				
			} else {
				left[i] = 1;
				
			}
			
		}

		right[n-1] = ratings[n-1];
		for (int i = n-2; i >= 0; i--) {
			if (ratings[i+1] < ratings[i]) {
				right[i] = right[i+1] + 1;
				
			} else {
				right[i] = 1;
				
			}
			
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			result += Math.max(left[i], right[i]);
			
		}

		return result;
		
	}
}
