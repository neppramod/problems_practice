import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		Solution sol = new Solution();
		sol.nextPermutation(arr);
		System.out.println(Arrays.toString(arr));
    }

	/*
	  Algorithm:
	  1. Scan from right, find first element when nums[i] > nums[i-1]
	  2. Mark nums[i]
	  3. If mark is not found reverse all the elements
	  4. Find first element right of mark that is greater than mark, swap mark and the element and reverse all elements mark + 1 to the right

	 */
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int mark = -1;
		int n = nums.length;
		
		for (int i = n-1; i > 0; i--) {
			if (nums[i] > nums[i-1]) {
				mark = i-1;
				break;
			}
		}

		if (mark == -1) {
			reverse(nums, 0, n-1);
		} else {
			for (int i = n-1; i >= mark; i--) {
				if (nums[i] > nums[mark]) {
					swap(nums, i, mark);
					reverse(nums, mark + 1, n-1);
				}
			}
		}
    }

	void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	void reverse(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}
}
