import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] nums = { -2, -1, 2, 1 };
		int k = 1;

		int result = sol.maxSubArrayLen(nums, k);
		System.out.println(result);
    }
    
	public int maxSubArrayLen(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		maxLen = 0;
		int sum = 0;
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			sum += nums[i];

			if (sum == k) {
				maxLen = Math.max(maxLen, i + 1);
			}

			int diff = sum - k;

			if (map.containsKey(diff)) {
				maxLen = Math.max(maxLen, i - map.get(diff));
			}

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}

		return maxLen;
		
	}
}
