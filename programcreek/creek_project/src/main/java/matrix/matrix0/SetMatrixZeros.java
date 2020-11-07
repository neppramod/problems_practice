package matrix.matrix0;

/**
 * Set Matrix Zeros
 * 
 * Given a m * n matrix, if an element is 0, set its entire row and column to 0. 
 * Do it in place
 */

import java.util.*;

public class SetMatrixZeros {
	public void setZeroes(int[][] matrix) {
		boolean firstRowZero = false;
		boolean firstColumZero = false;

		int m = matrix.length;
		int n = matrix[0].length;
		
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				firstRowZero = true;
			}
		}

		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				firstColumZero = true;
			}
		}

		// now mark
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][i] = 0;
				}
			}
		}

		// now make values zeros
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// fix first row and col
		if (firstRowZero) {
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}

		if (firstColumZero) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
