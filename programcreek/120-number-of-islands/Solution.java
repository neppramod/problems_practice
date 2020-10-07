import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		char[][] grid = {"11110".toCharArray(),
			"11010".toCharArray(),
			"11000".toCharArray(),
			"00000".toCharArray()};
		int result = sol.numIslands(grid);
		System.out.println(result);
    }
    
    public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;

		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					count++;
					merge(grid, i, j);
				}
			}
		}

		return count;
	}

	static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	void merge(char[][] grid, int i, int j) {
		int m = grid.length;
		int n = grid[0].length;

		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
			return;
		}

		grid[i][j] = '#';
		for (int k = 0; k < moves.length; k++) {
			merge(grid, i + moves[k][0], j + moves[k][1]);
		}
		
	}
}
