package dfs.shortestdistance;

import java.util.*;

public class ShortestDistanceFromAllBuildings {
    public static void main(String[] args) {
	    ShortestDistanceFromAllBuildings sol = new ShortestDistanceFromAllBuildings();
		int[][] matrix = new int[5][5];
		matrix[0][0] = 1;
		matrix[0][4] = 1;
		matrix[2][2] = 1;
		matrix[0][2] = 2;

		int result = sol.shortestDistance(matrix);
		System.out.println(result);
	}

	int shortestDistance(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] distance = new int[m][n];
		int[][] reach = new int[m][n];
		int numBuilding = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					helper(grid, distance, reach, i, j);
					numBuilding++;
				}
			}
		}

		int result = Integer.MAX_VALUE;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0 && reach[i][j] == numBuilding) {
					result = Math.min(result, distance[i][j]);
				}
			}
		}

		return result == Integer.MAX_VALUE ? -1 : result;
	}

	void helper(int[][] matrix, int[][] distance, int[][] numOfBuildings, int i, int j) {
		int[] dx = {0,  0, -1, 1};
		int[] dy = {-1, 1, 0, 0};

		int m = matrix.length;
		int n = matrix[0].length;

		Queue<int[]> reachablePoints = new LinkedList<>();
		Queue<Integer> distanceQueue = new LinkedList<>();

		reachablePoints.add(new int[]{i, j});
		distanceQueue.add(1);

		while (!reachablePoints.isEmpty()) {
			int[] curPoint = reachablePoints.poll();
			int dist = distanceQueue.poll();
			
			for (int k = 0; k < 4; k++) {
				int x = curPoint[0] + dx[k];
				int y = curPoint[1] + dy[k];

				if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] == 0) {
					matrix[x][y] = -1;   // invalidate now, so that same node is not processed again in this iteration of x and y

					// this is one more place that can be reached from i, j
					distance[x][y] += dist;
					numOfBuildings[x][y]++;

					reachablePoints.add(new int[] { x, y });
					distanceQueue.add(dist + 1);
				}
			}
		}

		// let's reset all the places turned to -1 from 0, so that matrix is good for next iteration of i and j
		for (int a = 0; a < m; a++) {
			for (int b = 0; b < n; b++) {
				if (matrix[a][b] == -1) {
					matrix[a][b] = 0;
				}
			}
		}
	}
    
}
