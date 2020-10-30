import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] nums = { 1, 3, 5, 4, 7 };
		int result = sol.findNumberOfLIS(nums);
		System.out.println(result);
    }
    
	public int findNumberOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;
		int[] length = new int[n];
		int[] count = new int[n];

		Arrays.fill(length, 1);
		Arrays.fill(count, 1);
		int lis = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (length[j] + 1 > length[i]) {
						length[i] = length[j] + 1;
						count[i] = count[j];
					} else if (length[j] + 1 == length[i]) {
						count[i] += count[j];
					}

				}

				lis = Math.max(lis, length[i]);
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			if (length[i] == lis) {
				result += count[i];
			}
		}

		return result;
    }
}
