import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int[] arr = {34, 23, 1, 24, 75, 33, 54, 8};
		int K = 60;
		int result = sol.twoSumLessThanK(arr, K);
		System.out.println(result);
	}
	
    // Given an array find two elements that sums to less than K, but is maximum
	// In all combination
	// Limit A length, 1 to 100
	// Each item 1 to 1000
	// K 1 to 2000
	public int twoSumLessThanK(int[] A, int K) {
		Arrays.sort(A);
		int n = A.length;
		
		int i = 0, j = n - 1;
		int maxSum = -1;

		while (i < j) {
			int curSum = A[i] + A[j];
			if (curSum >= K) {
				j--;
			} else {
				maxSum = Math.max(maxSum, curSum);
				i++;
			}
		}

		return maxSum;
    }
}
