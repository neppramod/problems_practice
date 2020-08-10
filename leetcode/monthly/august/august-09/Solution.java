import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[][] grid = { { 0, 2 } };
		int result = sol.orangesRotting(grid);
		System.out.println(result);
    }
    
	public int orangesRotting(int[][] grid) {
		int timer = 0;
		int previousFreshCount = Integer.MAX_VALUE;
		while (true) {
			int freshCount = getFreshCount(grid);
			if (freshCount == previousFreshCount) {
				if (freshCount > 0) {
					return -1;
				} else {
					return 0;
				}
			} else if (freshCount == 0) {
				return timer;
			} else {
				timer++;
				updateRotten(grid);
				previousFreshCount = freshCount;
			}
		}
    }

	void updateRotten(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] marked = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					if (i - 1 >= 0 && grid[i-1][j] == 1) {
						marked[i - 1][j] = true;
					}

					if (i + 1 < m && grid[i+1][j] == 1) {
						marked[i + 1][j] = true;
					}

					if (j - 1 >= 0 && grid[i][j - 1] == 1) {
						marked[i][j - 1] = true;
					}

					if (j + 1 < n && grid[i][j+1] == 1) {
						marked[i][j + 1] = true;
					}
				}
				
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (marked[i][j]) {
					grid[i][j] = 2;
				}
			}
		}
	}

	int getFreshCount(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					count++;
				}
			}
		}
		
		return count;
	}
}

/*
+---+---+---+
|2  |1  |1  |
|   |   |   |
|   |   |   |
+---+---+---+
|0  |1  |1  |
|   |   |   |
|   |   |   |
+---+---+---+
|1  |0  |1  |
|   |   |   |
|   |   |   |
+---+---+---+

initialize timer
1. count fresh cells
2. create array of changing cells (neighbor of rotten)
3. change all those cells
4. count fresh cells
5. if (count of fresh cells did not change or not equal to 0, return -1)
6. else return current time counter
 */
