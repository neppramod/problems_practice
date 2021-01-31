import java.util.*;

public class Solution
{
	public int removeDuplicates(int[] nums) {
		if (nums == null) {
			return 0;
		}

		if (nums.length <= 2) {
			return nums.length;
		}

		int i = 0, j = 1;
		
		while (j < nums.length) {
			if (nums[i] == nums[j]) {
				if (i == 0) {
					i++;
					j++;
				} else if (nums[i] == nums[i-1]) {
					j++;
				} else {
					i++;
					nums[i] = nums[j];
					j++;
				}
			} else {
				i++;
				nums[i] = nums[j];
				j++;
			}
		}

		return i + 1;

	}

	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 2, 2, 3};
		Solution sol = new Solution();
		int result = sol.removeDuplicates(arr);
		System.out.println(result);
	}

}
