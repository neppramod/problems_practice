import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[][] matrix = {{9, 9, 4},
						  {6, 6, 8},
						  {2, 1, 1}};
		int res = sol.longestIncreasingPath(matrix);
		System.out.println(res);
    }

	static int[][] moves = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	
    public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int[] max = new int[1];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				dfs(matrix, i, j, max, 1);
			}
		}

		return max[0];
	}

	void dfs(int[][] matrix, int i, int j, int[] max, int len) {
		max[0] = Math.max(max[0], len);

		int m = matrix.length;
		int n = matrix[0].length;

		for (int k = 0; k < 4; k++) {
			int x = i + moves[k][0];
			int y = j + moves[k][1];

			if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
				dfs(matrix, x, y, max, len + 1);
			}
		}
	}
}
