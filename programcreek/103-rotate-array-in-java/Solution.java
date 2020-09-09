import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int k = 7;
		sol.rotate(arr, k);
		System.out.println(Arrays.toString(arr));
    }
    
    public void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k % n;

		// length of first part
		k = nums.length - k;
		
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
		reverse(nums, 0, n - 1);
	}

	void reverse(int[] nums, int i, int j) {
		while (i < j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;
			j--;
		}
	}
	
}
