import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int[] nums = { 3, 1 };
		boolean result = sol.search(nums, 3);
		System.out.println(result);
	}
	
    public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}

		int n = nums.length;

		int l = 0;
		int r = n - 1;

		while (l <= r) {
			int m = l + (r - l) / 2;

			if (nums[m] == target) {
				return true;
			} else if (nums[l] < nums[m]) {
				if (target >= nums[l] && target < nums[m]) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			} else if (nums[l] > nums[m]) {
				if (target > nums[m] && target <= nums[r]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			} else {
				l++;
			}
		}

		return false;
    }
}
