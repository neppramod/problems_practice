import java.util.*;

public class Solution
{
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] maze = {{0, 0, 1, 0, 0},
						{0, 0, 0, 0, 0},
						{0, 0, 0, 1, 0},
						{1, 1, 0, 1, 1},
						{0, 0, 0, 0, 0}
		};

		int[] start = {0, 4};
		int[] dest = {4, 4};
		boolean ans  = sol.hasPath(maze, start, dest);
		System.out.println(ans);
	}

	public boolean hasPath(int[][] maze, int[] start, int[] dest) {
		int m = maze.length;
		int n = maze[0].length;

		boolean[][] visited = new boolean[m][n];
		return hasPath(maze, visited, start[0], start[1], dest[0], dest[1]);
	}

	static int[][] steps = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

	boolean hasPath(int[][] maze, boolean[][] visited, int i, int j, int k, int l) {
		int m = maze.length;
		int n = maze[0].length;

		if (visited[i][j]) {
			return false;
		} else if (i == k && j == l) {
			return true;
		}

		visited[i][j] = true;

		for (int p = 0; p < 4; p++) {
			int xp = i;
			int yp = j;

			while (isValid(xp + steps[p][0], yp + steps[p][1], maze)) {
				xp += steps[p][0];
				yp += steps[p][1];
			}

			if (hasPath(maze, visited, xp, yp, k, l)) {
				return true;
			}
		}

		return false;


	}

	boolean isValid(int i, int j, int[][] maze) {
		int m = maze.length;
		int n = maze[0].length;

		if (i < 0 || i >= m) {
			return false;
		}

		if (j < 0 || j >= n) {
			return false;
		}

		if (maze[i][j] == 1) {
			return false;
		}

		return true;
	}
}
