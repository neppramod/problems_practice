import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int[] A = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		int K = 2;
		System.out.println(sol.longestOnes(A, K));
	}
	
    public int longestOnes(int[] A, int K) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int max = 0;
		int i = -1;
		int n = A.length;
		int count = 0;
		
		for (int j = 0; j < n; j++) {
			if (A[j] == 0) {
				count++;
			}

			while (count > K) {
				i++;
				if (A[i] == 0) {
					count--;
				}
			}

			max = Math.max(max, j - i);
		}

		return max;
    }
}
