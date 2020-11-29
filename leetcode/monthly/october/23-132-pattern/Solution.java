import java.util.*;

public class Solution
{
	public boolean find132pattern(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		}

		int n = nums.length;
		int[] minArr = new int[n];
		
		minArr[i] = nums[0];
		for (int i = 1; i < n; i++) {
			minArr[i] = Math.min(nums[i], minArr[i-1]);
		}

		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int i = n-1; i >= 1; i--) {
			Integer right = treeSet.lower(nums[i]);

			if (right != null) {
				int left = minArr[i-1];
				
				if (left < right) {
					return true;
				}
			}

			treeSet.add(nums[i]);
		}

		return false;
	}
}
