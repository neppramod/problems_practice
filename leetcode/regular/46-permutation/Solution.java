import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int[] nums = { 18, 21, 13, 14};
		// 4! = 4 * 3 * 2 * 1 = 24

		// handle up to n = 6, not more than that
		// 15 is TOO BIG
		List<List<Integer>> result = sol.permute(nums);

		for (List<Integer> l : result) {
			System.out.println(l);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		permute(nums, 0, result);
		return result;
	}

	void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}


	void permute(int[] nums, int start, List<List<Integer>> result) {
		if (start == nums.length) {

			// since nums is primitive int, we cannot use Arrays.asList
			List<Integer> list = new ArrayList<>();
			for (int n : nums) {
				list.add(n);
			}
			
			result.add(list);
		} else {
			for (int i = start; i < nums.length; i++) {
				swap(nums, i, start);
				permute(nums, start + 1, result);
				swap(nums, i, start);
			}
		}
	}
}
