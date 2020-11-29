
public class FlippingAnImage {
	public int[][] flipAndInvertImage(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			revertRow(A[i]);
		}

		invertImage(A);
		return A;
    }

	void invertImage(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = matrix[i][j] == 1 ? 0 : 1;
			}
		}
	}

	void revertRow(int[] arr) {
		int i = 0, j = arr.length - 1;
		while (i < j) {
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;
		}
	}
}
