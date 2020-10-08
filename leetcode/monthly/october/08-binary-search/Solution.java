import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] nums = {-1, 0, 3, 5, 9, 12};
		int target = -1;
		System.out.println(sol.search(nums, target));
    }
    
    public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		return binarySearch(nums, 0, nums.length-1, target);
    }

	int binarySearch(int[] nums, int start, int end, int target) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] < target) {
			return binarySearch(nums, mid + 1, end, target);
		} else {
			return binarySearch(nums, start, mid-1, target);
		}
	}
}
