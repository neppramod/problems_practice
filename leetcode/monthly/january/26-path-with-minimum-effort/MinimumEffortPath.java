import java.util.*;

public class MinimumEffortPath {
    public static void main(String[] args) {
	    MinimumEffortPath sol = new MinimumEffortPath();
		int[][] heights = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
		int res = sol.minimumEffortPath(heights);
		System.out.println(res);
	}

	int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	
    public int minimumEffortPath(int[][] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}

		// Dijkstra's algorithm (similar technique) as shortest distance from src to all vertices
		// Here instead of distance we update the minimum effort and when we reach the dest
		// we have our answer

		int m = heights.length;
		int n = heights[0].length;

		// to track visited cells
		boolean[][] visited = new boolean[m][n];

		// dijkstra's effort
		// we update the values as we visit
		// initially all initialized to INF
		// only src to 0
		int[][] effort = new int[m][n];
		for (int i = 0; i < m; i++) {
			Arrays.fill(effort[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<Cell> pq = new PriorityQueue<>();
		effort[0][0] = 0;  // src node initialized to 0, so that it gets picked first
		pq.add(new Cell(0, 0, effort[0][0]));

		while (!pq.isEmpty()) {
			Cell cur = pq.poll();
			visited[cur.x][cur.y] = true;
			
			if (cur.x == m-1 && cur.y == n-1) {
				return cur.effort;
			}

			for (int k = 0; k < 4; k++) {
				int dx = cur.x + moves[k][0];
				int dy = cur.y + moves[k][1];

				if (dx >= 0 && dx < m && dy >= 0 && dy < n && !visited[dx][dy]) {
					int curEffort = Math.abs(heights[cur.x][cur.y] - heights[dx][dy]);

					int maxDiff = Math.max(cur.effort, curEffort);
					if (maxDiff < effort[dx][dy]) {
						Cell nCell = new Cell(dx, dy, maxDiff);
						pq.add(nCell);
					}
				}
			}
		}

		return effort[m - 1][n - 1];
		
    }

	static class Cell implements Comparable<Cell> {
		int x, y;
		int effort;

		public Cell(int x1, int y1, int effort1) {
			x = x1;
			y = y1;
			effort = effort1;
		}

		public int compareTo(Cell o) {
			return effort - o.effort;
		}
	}
}
