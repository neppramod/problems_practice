import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] arr = {1, 3, 1, 2, 0, 5};
		int[] result = sol.maxSlidingWindow(arr, 2);
		System.out.println(Arrays.toString(result));
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}

		Deque<Integer> queue = new LinkedList<>();
		int n = nums.length;
		int[] result = new int[n - k + 1];

		for (int i = 0; i < n; i++) {

			// remove out of bound element
			if (!queue.isEmpty() && queue.peekFirst() == i-k) {
				queue.removeFirst();
			}

			// remove all small elements so that head is the largest
			while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
				queue.removeLast();
			}

			queue.add(i);

			if (i - k + 1 >= 0) {
				result[i - k + 1] = nums[queue.peekFirst()];
			}
		}

		return result;
	}
}
