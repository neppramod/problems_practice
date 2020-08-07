import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {

		Solution sol = new Solution();
		int[] nums = {1, 1, 1, 1, 2, 2, 4, 5, 5, 5, 5, 7, 7, 9};
		int len = sol.removeElement(nums, 5);
		System.out.println("Len: " + len);
		System.out.println(Arrays.toString(nums));
     
    }

	int removeElement(int[] nums, int element) {
		int i = 0, j = 0;
		while (j < nums.length) {
			if (nums[j] != element) {
				nums[i] = nums[j];
				i++;
				j++;
			} else {
				j++;
			}
		}

		return i;
	}
    
}
