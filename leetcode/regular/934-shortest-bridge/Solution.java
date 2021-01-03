import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		//		int[][] A = {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
		int[][] A = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
		int result = sol.shortestBridge(A);
		System.out.println(result);
	}
	
    /*
	  Since the array size is less than or equal to 100x100, we can loop through the matrix, flood fill, pick all the land units in 2 sets for each
island, then get the shortest distance between all of them using dist = sqrt(sqr(x1 - x2) + sqr(y1 - y2))
	 */

	public int shortestBridge(int[][] A) {
		int m = A.length;
		int n = A[0].length;

		Set<Pair> set1 = new HashSet<>();
		Set<Pair> set2 = new HashSet<>();
		boolean[][] visited = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (A[i][j] == 0) {
					continue;
				}
				
				if (set1.isEmpty() && !visited[i][j]) {
					floodfill(A, i, j, set1, visited);
				} else if (set2.isEmpty() && !visited[i][j]) {
					floodfill(A, i, j, set2, visited);
				}
			}
		}

		int min = Integer.MAX_VALUE;
		
		for (Pair p1 : set1) {
			for (Pair p2 : set2) {
				int x1 = Math.abs(p1.x - p2.x);
				int y1 = Math.abs(p1.y - p2.y);
				
				//int dist = (int)Math.sqrt(x1 * x1 + y1 * y1) - 1;
				int dist = x1 + y1 - 1;
				min = Math.min(min, dist);
			}
		}

		return min;
    }

	int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	void floodfill(int[][] A, int i, int j, Set<Pair> set, boolean[][] visited) {

		if (visited[i][j]) {
			return;
		}
		
		set.add(new Pair(i, j));
		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int dx = i + moves[k][0];
			int dy = j + moves[k][1];

			Pair p1 = new Pair(dx, dy);
			if (dx >= 0 && dx < A.length && dy >= 0 && dy < A[0].length && A[dx][dy] == 1) {
				floodfill(A, dx, dy, set, visited);
			}
		}
	}

	static class Pair {
		int x, y;

		public Pair(int x1, int y1) {
			x = x1;
			y = y1;
		}

		public boolean equals(Object o) {
			Pair p1 = (Pair)o;

			return p1.x == x && p1.y == y;
		}

		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
}
