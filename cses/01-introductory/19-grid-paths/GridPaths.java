import java.util.*;

// TLE, needs more optimization
// But the solution is correct
public class GridPaths {
    public static void main(String[] args) {
	    GridPaths sol = new GridPaths();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int result = sol.countPaths(s);
		System.out.println(result);
	}
	
    static int count = 0;
	static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U, D, L, R
	static char[] movechars = {'U', 'D', 'L', 'R'};
	static final int N = 7;
	static final int PATH_MAX = 48;
	
	int countPaths(String input) {
		char[] s = input.toCharArray();
		boolean[][] visited = new boolean[N][N];
		
		countPaths(s, visited, 0, 0, 0);
		return count;
	}

	void countPaths(char[] s, boolean[][] visited, int row, int col, int pathCount) {
		if (row == N-1 && col == 0 && pathCount == PATH_MAX) {
			count++;
		} else {
			if (pathCount >= PATH_MAX || visited[row][col]) {
				return;
			} else {
				visited[row][col] = true;
				
				for (int k = 0; k < 4; k++) {
					int dx = row + moves[k][0];
					int dy = col + moves[k][1];
					char nextPath = movechars[k];
					
					if (dx < N && dx >= 0 && dy < N && dy >= 0 && (s[pathCount] == nextPath || s[pathCount] == '?')) {
						countPaths(s, visited, dx, dy, pathCount + 1);
					}
				}

				visited[row][col] = false;
			}
		}
	}
}
