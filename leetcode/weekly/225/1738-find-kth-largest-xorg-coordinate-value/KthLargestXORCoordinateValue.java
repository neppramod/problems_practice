import java.util.*;

public class KthLargestXORCoordinateValue {
    public static void main(String[] args) {
	    KthLargestXORCoordinateValue sol = new KthLargestXORCoordinateValue();
		
	}

	// dp
	// create a result matrix
	// build result and add to list
	// sort the list (in reverse) and return k-1 index value 
    public int kthLargestValue(int[][] matrix, int k) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		int[][] xored = new int[m][n];
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				xored[i][j] = matrix[i][j];

				// xor from top
				if (i > 0) {
					xored[i][j] ^= xored[i-1][j];
				}

				// xored from left
				if (j > 0) {
					xored[i][j] ^= xored[i][j-1];
				}

				// xored from diagonal left, because it was cancelled in above 2 operations top and left
				if (i > 0 && j > 0) {
					xored[i][j] ^= xored[i-1][j-1];
				}

				list.add(xored[i][j]);
			}
		}

		Collections.sort(list, Collections.reverseOrder());
		return list.get(k - 1);
	}
}
