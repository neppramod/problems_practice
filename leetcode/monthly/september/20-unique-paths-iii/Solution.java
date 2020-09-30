import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
		System.out.println(sol.uniquePathsIII(grid));
    }
    
    public int uniquePathsIII(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int totalZeros = 0;
		int startX = 0, startY = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					totalZeros++;
				}

				else if (grid[i][j] == 1) {
					startX = i;
					startY = j;
				}
			}
		}

		return dfs(grid, totalZeros, -1, startX, startY);  // if count is equal to totalZeros + 1 (for start cell), we have answer
    }

	int dfs(int[][] grid, int totalZeros, int curZeros, int x, int y) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y]  == -1) {
			return 0;
		}

		if (grid[x][y] == 2) {
			return curZeros == totalZeros ? 1 : 0;
		}

		grid[x][y] = -1;
	

		int result = dfs(grid, totalZeros, curZeros + 1, x + 1, y) + dfs(grid, totalZeros, curZeros + 1, x - 1, y)
				+ dfs(grid, totalZeros, curZeros + 1, x, y + 1) + dfs(grid, totalZeros, curZeros + 1, x, y - 1);

		
		grid[x][y] = 0;
				
		return result;
	}
}
