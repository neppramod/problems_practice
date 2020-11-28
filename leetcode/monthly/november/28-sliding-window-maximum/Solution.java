import java.util.Deque;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int[] nums = {1, 3, 1, 2, 0, 5};
		int k = 3;
		int[] result = sol.maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(result));
	}
	
    public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		
		int n = nums.length;
		int[] result = new int[n - k + 1];
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			if (!deque.isEmpty() && deque.peekFirst() == i - k) {
				deque.poll();
			}

			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}

			deque.add(i);

			// 2 is 3rd index
			if (i + 1 -k >= 0) {
				result[i + 1 - k] = nums[deque.peek()];
			}
		}
		return result;
    }


}
