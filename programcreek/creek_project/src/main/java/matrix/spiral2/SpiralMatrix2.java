package matrix.spiral2;


import java.util.*;

public class SpiralMatrix2 {

	public int[][] generateMatrix(int P) {
		int total = P * P;

		int cur = 1;

		int m = P;
		int n = P;
		int[][] matrix = new int[P][P];

		int x = 0;
		int y = 0;

		while (m > 0 && n > 0) {
			if (m == 1) {
				for (int i = 0; i < n; i++) {
					matrix[x][y++] = cur++;
				}
				break;
			}

			else if (n == 1) {
				for (int i = 0; i < m; i++) {
					matrix[x++][y] = cur++;
				}
				break;
			}

			// spiral
			// top left to right
			for (int i = 0; i < n-1; i++) {
				matrix[x][y++] = cur++;
			}

			// right top to bottom
			for (int i = 0; i < m-1; i++) {
				matrix[x++][y] = cur++;
			}

			// bottom right to left
			for (int i = 0; i < n-1; i++) {
				matrix[x][y--] = cur++;
			}

			// left bottom to up
			for (int i = 0; i < m-1; i++) {
				matrix[x--][y] = cur++;
			}

			// move x, y in
			x++;
			y++;

			// remove 2 blocks outside (boundary)
			m -= 2;
			n -= 2;
		}


		return matrix;
	}
    
}
