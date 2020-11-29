package rangequery;

public class RangeSumQuery2D {
	int[][] sum;
	
 	public RangeSumQuery2D(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		sum = new int[m][n];

		for (int i = 0; i < m; i++) {
			int sumRow = 0;

			for (int j = 0; j < n; j++) {
				if (i == 0) {
					sumRow += matrix[i][j];
					sum[i][j] += sumRow;
				} else {
					sumRow += matrix[i][j];
					sum[i][j] += sumRow + matrix[i - 1][j];
				}
			}
		}
	}
}
