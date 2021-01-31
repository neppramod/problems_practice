import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int[] nums = { 0, 1, 2, 4, 5, 7 };
		List<String> result = sol.summaryRanges(nums);
		System.out.println(result);
	}
	
    public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		int n = nums.length;
		int start = nums[0], pre = nums[0];
		
		for (int i = 1; i < n; i++) {
			if (nums[i] == nums[i-1] + 1) {
				pre = nums[i];				
			} else {
				result.add(getRange(start, pre));
				start = nums[i];
				pre = nums[i];
			}
		}


		// add the missing value
		result.add(getRange(start, pre));
		

		return result;
		
	}

	String getRange(int i, int j) {
		if (i == j ) {
			return String.valueOf(i);
		} else {
			return i + "->" + j;
		}
	}
}
