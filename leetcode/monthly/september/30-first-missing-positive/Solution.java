import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] arr = {1};
		int result = sol.firstMissingPositive(arr);
		System.out.println(result);
    }
    
    int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}

		int n = A.length;

	   

		for (int i = 0; i < n; i++) {
			// when ith element is not i
			while (A[i] >= 1 && A[i] <= n && A[i] != A[A[i]-1]) {

				swap(A, i, A[i]-1);
			}
		}

		for (int i = 0; i < n; i++) {
			if (A[i] != i+1) {
				return i+1;
			}
		}

		return n + 1;
	}

	void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}




}
