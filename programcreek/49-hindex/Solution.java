import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] nums = {0, 1, 3, 5, 5, 6};
		System.out.println(sol.hindex(nums));
    }
    
    int hindex(int[] nums) {
		int count = 0;
		int n = nums.length;

		Arrays.sort(nums);
		
		for (int i = n-1; i >= 0; i--) {
			if (nums[i] > count) {
				count++;
			} else {
				break;
			}
		}

		return count;
	}
}
