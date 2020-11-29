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
		int res1 = sol.longestIncreasingPathMemoized(matrix);
		System.out.println(res1);
    }

	static int[][] moves = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

	public int longestIncreasingPath(int[][] matrix) {
		int result = 0;

		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result = Math.max(result, dfs(matrix, i, j, 1));
			}
		}

		return result;
	}

	int dfs(int[][] matrix, int i, int j, int len) {
		int m = matrix.length;
		int n = matrix[0].length;

		int result = 0;
		for (int k = 0; k < 4; k++) {
			int x = i + moves[k][0];
			int y = j + moves[k][1];

			if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
				result = Math.max(result, dfs(matrix, x, y, len + 1));
			}
		}

		// add 1 to current cell
		return result + 1;
	}

	int longestIncreasingPathMemoized(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m][n];
		int result = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result = Math.max(result, dfsmemoized(matrix, dp, i, j, 1));
			}
		}

		return result;
	}

	int dfsmemoized(int[][] matrix, int[][] dp, int i, int j, int len) {

		if (dp[i][j] > 0) {
			return dp[i][j];
		}
		
		int m = matrix.length;
		int n = matrix[0].length;

		int result = 0;
		for (int k = 0; k < 4; k++) {
			int x = i + moves[k][0];
			int y = j + moves[k][1];

			if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
				result = Math.max(result, dfsmemoized(matrix, dp, x, y, len + 1));
			}
		}

		// add 1 to current cell
		return dp[i][j] = result + 1;
	}

}
