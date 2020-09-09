import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] nums1 = {1, 7, 11};
		int[] nums2 = {2, 4, 6};
		int k = 3;

		List<int[]> result = sol.kSmallestPairs(nums1, nums2, k);
		for (int[] a : result) {
			System.out.println(Arrays.toString(a));
		}
    }
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		int total = nums1.length * nums2.length;

		if (total < k) {
			k = total;
		}

		List<int[]> result = new ArrayList<>();
		int[] idx = new int[nums1.length];  // track each element cursor in nums2

		while (k > 0) {

			int min = Integer.MAX_VALUE;
			int minIdx = -1;

			for (int i = 0; i < nums1.length; i++) {
				if (idx[i] < nums2.length && nums1[i] + nums2[idx[i]] < min) {
					minIdx = i;
					min = nums1[i] + nums2[idx[i]];
				}
			}

			result.add(new int[] {nums1[minIdx], nums2[idx[minIdx]]});
			idx[minIdx]++;

			k--;
		}

		return result;
	}
}
