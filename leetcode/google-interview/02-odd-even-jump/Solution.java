import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] A = { 2, 3, 1, 1, 4 };
		int result = sol.oddEvenJumps(A);
		System.out.println(result);

	}

	public int oddEvenJumps(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int result = 1;

		int n = A.length;
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		boolean[] higher = new boolean[n];
		boolean[] lower = new boolean[n];

		higher[n - 1] = true;
		lower[n - 1] = true;

		treeMap.put(A[n - 1], n - 1);

		for (int i = n-2; i >= 0; i--) {
			Map.Entry hi = treeMap.ceilingEntry(A[i]);
			Map.Entry lo = treeMap.floorEntry(A[i]);

			if (hi != null) {
				higher[i] = lower[(int) hi.getValue()];				
			}

			if (lo != null) {
				lower[i] = higher[(int) lo.getValue()];
			}

			if (higher[i]) {
				result++;
			}

			treeMap.put(A[i], i);
		}
		
		return result;
	}
}
