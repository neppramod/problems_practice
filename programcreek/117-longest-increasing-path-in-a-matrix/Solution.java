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
	
	public int longestIncreasingPathMemoized(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int result = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int t = helper(matrix, dp, i, j);
				result = Math.max(result, t);
			}
		}

		return result;
	}

	int helper(int[][] matrix, int[][] dp, int i, int j) {
		if (dp[i][j] > 0) {
			return dp[i][j];
		}

		int m = matrix.length;
		int n = matrix[0].length;
		
		for (int k = 0; k < 4; k++) {
			int x = i + moves[k][0];
			int y = j + moves[k][1];

			if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
				dp[i][j] = Math.max(dp[i][j], helper(matrix, dp, x, y));
			}
		}

		dp[i][j] = dp[i][j] + 1;
		return dp[i][j];
	}

}
