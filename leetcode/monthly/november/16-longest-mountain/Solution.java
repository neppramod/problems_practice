import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		//int[] arr = { 2, 1, 4, 7, 3, 2, 5 };
		//int[] arr = { 2, 2, 2 };
		int[] arr = { 0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		int result = sol.longestMountain(arr);
		System.out.println(result);
	}
	
    public int longestMountain(int[] A) {
		if (A == null || A.length < 3) {
			return 0;
		}

		int maxLength = 0;
		int n = A.length;
		int len1 = 0;
		int len2 = 0;
		
		for (int i = 1; i < n; i++) {

			if (len2 > 0 && A[i] > A[i-1] || A[i-1] == A[i]) {
				len1 = 0;
				len2 = 0;

			}
			
			if(A[i] > A[i-1]) {
				len1++;
			}				


			if (A[i] < A[i-1]) {
				len2++;
			}
			
			if (len1 > 0 && len2 > 0) {
				maxLength = Math.max(maxLength, len1 + len2 + 1);
			} 
			
		}

		return maxLength;
    }
}
