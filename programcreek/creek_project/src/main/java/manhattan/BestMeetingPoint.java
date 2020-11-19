package manhattan;

import java.util.*;

public class BestMeetingPoint {
	
	public 	int minTotalDistance(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		int sum = 0;

		for (int r : rows) {
			sum += Math.abs(r - rows.get(rows.size() / 2));
		}

		Collections.sort(cols);
		for (int c : cols) {
			sum += Math.abs(c - cols.get(cols.size() / 2));
		}

		return sum;
	}
}
