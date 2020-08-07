import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] nums = {1, 1, 1, 1, 2, 2, 4, 5, 5, 5, 5, 7, 7, 9};
		int len = sol.removeDup(nums);
		System.out.println("Len: " + len);
		System.out.println(Arrays.toString(nums));
    }
    
    int removeDup(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		} else {
			int i = 1, j = 2;

			while (j < nums.length) {
				if (nums[j] == nums[i] && nums[j] == nums[i-1]) {
					j++;
				} else {
					i++;
					nums[i] = nums[j];
					j++;
				}
			}

			return i+1;
		}
	}
}
