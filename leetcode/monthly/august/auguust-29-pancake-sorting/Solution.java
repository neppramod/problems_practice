import java.util.*;
 
public class Solution
{
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] A = {3, 2, 4, 1};
		List<Integer> res = sol.pancakeSort(A);
		System.out.println(res);
		System.out.println(Arrays.toString(A));
	}
    
	public List<Integer> pancakeSort(int[] A) {
		List<Integer> list = new ArrayList<>();

		if (A == null || A.length == 0) {
			return list;
		}
		int n = A.length;

		for (int cur = n; cur > 1; cur--) {
			int maxInd = maxIndex(A, cur);

			if (maxInd != cur-1) {
				list.add(maxInd + 1);
				reverse(A, maxInd);

				list.add(cur + 1);
				reverse(A, cur-1);

			}

			
		}

		return list;
	}

	private int maxIndex(int[] A, int n) {
		int maxIndex = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] > A[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	private void reverse(int[] A, int j) {
		int i = 0;
		while (i < j) {
			int tmp = A[i];
			A[i] = A[j];
			A[j] = tmp;
			i++;
			j--;
		}
	}
}
