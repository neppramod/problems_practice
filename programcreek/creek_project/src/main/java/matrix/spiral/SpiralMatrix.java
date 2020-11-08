package matrix.spiral;

import java.util.ArrayList;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix
 * in spiral order
 * 
 * For example, given the following matrix:
 * [[1, 2, 3]
 *  [4, 5, 6]
 *  [7, 8, 9]]
 * 
 * You should return [1, 2, 3,6, 9, 8, 7, 4, 5]
 */
public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<>();

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int x = 0, y = 0;
		while (m > 0 && n > 0) {
			// if m == 0 or n == 0, handle single row or col, otherwise handle spiral
			if (m == 1) {
				for (int i = 0; i < n; i++) {
					result.add(matrix[x][y++]);
			
				}
				break;
			}
			
			else if (n == 1) {
				for (int i = 0; i < m; i++) {
					result.add(matrix[x++][y]);
				}
				break;
			}


			// process spiral
			// top to right
			for (int i = 0; i < n-1; i++) {
				result.add(matrix[x][y++]);
			}

			// top right to down
			for (int i = 0; i < m-1; i++) {
				result.add(matrix[x++][y]);
			}

			// down to left
			for (int i = 0; i < n-1; i++) {
				result.add(matrix[x][y--]);
			}

			// down left to top left
			for (int i = 0; i < m - 1; i++) {
				result.add(matrix[x--][y]);
			}

			// move inward
			x++;
			y++;

			// we now need to handle 2 blocks less on both left and right
			m -= 2;
			n -= 2;
		}

		return result;
	}

}

/*

  m = 3
  n = 3

  x = 0
  y = 0

  result = [1, 2, 3, 6, 9, 8, 7, 4]

  while m > 0, n > 0:

  x = 0, y = 0
  i = 0, 1

  x = 1, y = 1

  m = m - 2
  n = n - 2

*/
