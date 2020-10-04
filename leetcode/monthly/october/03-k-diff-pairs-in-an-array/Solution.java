import java.util.*;

public class Solution
{
	public static void main(String[] args) {
		Solution sol = new Solution();
/*
nums = [1, 1, 3, 4, 5]
 */

		int[] nums = {3, 1, 4, 1, 5};
		int res = sol.findPairs(nums, 2);
		System.out.println(res);
	}

	public int findPairs(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}

		int count = 0;
		for (int num : map.keySet()) {
			if (k > 0 && map.containsKey(num + k) || k == 0 && map.get(num) > 1) {
				count++;
			}
		}

		return count;
	}
}
