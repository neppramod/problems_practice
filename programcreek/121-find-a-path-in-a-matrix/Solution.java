import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[][] matrix = {{1, 0, 0, 0, 0},
						  {1, 0, 1, 1, 1},
						  {1, 1, 1, 0, 1},
						  {1, 0, 0, 0, 1},
						  {1, 0, 0, 0, 1}};
		int[][] result = sol.findPath(matrix);
		if (result != null) {
			for (int i = 0; i < result.length; i++) {
				System.out.println(Arrays.toString(result[i]));
			}	    
		}

    }

	int[][] findPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return null;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		List<int[]> list = new ArrayList<>();
		List<int[]> tmp = new ArrayList<>();

		dfs(matrix, 0, 0, tmp, list);

		int[][] result = new int[m][n];
		for (int i = 0; i < list.size(); i++) {
			result[list.get(i)[0]][list.get(i)[1]] = 1;
		}

		result[0][0] = 1;
		return result;
	}

	void dfs(int[][] matrix, int i, int j, List<int[]> tmp, List<int[]> list) {
		int m = matrix.length;
		int n = matrix[0].length;

		if (i == m-1 && j == n-1) {
			list.clear();
			list.addAll(tmp);
			return;
		}

		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};

		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];

			if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] == 1) {
				int prev = matrix[x][y];
				tmp.add(new int[]{x, y});
				matrix[x][y] = 0;
				dfs(matrix, x, y, tmp, list);
				matrix[x][y] = prev;
				tmp.remove(tmp.size()-1);
			}
		}
	}

}
