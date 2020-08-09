import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] nums = {1, -1, 5, -2, 3};
		int k = 3;
		int answer = sol.maxSubArrayLen(nums, 3);
		System.out.println(answer);
    }
    
    
	public int maxSubArrayLen(int[] nums, int k) {
        		int maxSize = 0;

		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		int n = nums.length;
		for (int i = 0; i < n; i++) {
			sum += nums[i];

			if (sum == k) {
				maxSize = Math.max(maxSize, i + 1);
			} 
            
            if (map.containsKey(sum-k)) {
				maxSize = Math.max(maxSize, i - map.get(sum-k));
			}

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		

		return maxSize;
    }

}
