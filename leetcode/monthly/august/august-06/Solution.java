import java.util.*;

// Find all duplicates in an array
// Element is within range, so negate, and if we see again add to answer
public class Solution
{
    public static void main(final String[] args) {
        final Solution sol = new Solution();
		final int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
		System.out.println(sol.findAllDuplicates(nums));
    }

	List<Integer> findAllDuplicates(final int[] nums) {
		final List<Integer> result = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return result;
		}
		
		
		final int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[Math.abs(nums[i]) - 1] < 0) {
				result.add(Math.abs(nums[i]));
			} else {
				nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
			}
		}

		return result;
	}
    
}
