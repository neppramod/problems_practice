import java.util.*;

public class MinimumEffortPathUnionFind {
    public static void main(String[] args) {
	    MinimumEffortPathUnionFind sol = new MinimumEffortPathUnionFind();
		int[][] heights = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
		int res = sol.minimumEffortPath(heights);
		System.out.println(res);
	}

	public int minimumEffortPath(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;

		if (m == 1 && n == 1) {
			return 0;
		}

		// create disjoint sets
		UnionFind unionFind = new UnionFind(heights);
		List<Edge> edgeList = unionFind.edgeList;

		// sort according to increasing order of diffence (lower first)
		Collections.sort(edgeList, (e1, e2) -> e1.difference - e2.difference);

		for (int i = 0; i < edgeList.size(); i++) {
			Edge e = edgeList.get(i);

			int x = e.x;
			int y = e.y;

			// union two edges
			// here x and y refers to edges either up row and down cell, or left and right cells
			unionFind.union(x, y);

			// if somehow we were able to connect 0th node (top left) with m * n - 1 (first element of last row), we have our answer. And this is through minimum path
			if (unionFind.find(0) == unionFind.find(m * n - 1)) {
				return edgeList.get(i).difference;
			}
		}

		return -1;
	}
	
    static class UnionFind {
		int[] parent;
		int[] rank;
		List<Edge> edgeList;


		public UnionFind(int[][] heights) {
			int m = heights.length;
			int n = heights[0].length;

			parent = new int[m * n];
			rank = new int[m * n];
			edgeList = new ArrayList<>();


			for (int row = 0; row < m; row++) {
				for (int col = 0; col < n; col++) {

					// edge with up
					if (row > 0) {
						Edge e = new Edge(row * n + col, (row - 1) * n + col, Math.abs(heights[row][col] - heights[row-1][col]));
						edgeList.add(e);
					}

					// edge with left
					if (col > 0) {
						Edge e = new Edge(row * n + col, row * n + (col-1), Math.abs(heights[row][col] - heights[row][col-1]));
						edgeList.add(e);
					}

					// set parent of current node to itself
					// disjoint sets
					parent[row * n + col] = row * n + col;
				}
			}
		}

		int find(int x) {
			if (parent[x] != x) {
				parent[x] = find(parent[x]);
			}

			return parent[x];
		}

		void union(int x, int y) {
			int parentX = find(x);
			int parentY = find(y);

			if (parentX != parentY) {
				if (rank[parentX] > rank[parentY]) {
					parent[parentY] = parentX;
				} else if (rank[parentX] < rank[parentY]) {
					parent[parentX] = parentY;
				} else {
					parent[parentY] = parentX;
					rank[parentX]++;
				}
			}
		}
	}

	static class Edge {
		int x;
		int y;
		int difference;

		public Edge(int x1, int y1, int diff1) {
			x = x1;
			y = y1;
			difference = diff1;
		}
	}
}
