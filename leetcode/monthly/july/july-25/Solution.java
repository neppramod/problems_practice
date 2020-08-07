import java.util.*;

class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] arr = {8, 9, 1, 2,3, 3, 3, 3, 4, 5, 6, 7};
		int result = sol.findMin(arr);
		System.out.println(result);
	}

	/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
	 */
	
	
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            int n = nums.length;
            int l = 0, r = n-1;
            while (l <= r) {
				while (nums[l] == nums[r] && l != r) {
					l++;
				}
				if (nums[l] <= nums[r]) {
					return nums[l];
				}
				
                int mid = l + (r-l)/2;

				if (nums[mid] >= nums[l]) {
					l = mid + 1;
				} else {
					r = mid;
				}
            }
			return -1;
        }
    }
}
