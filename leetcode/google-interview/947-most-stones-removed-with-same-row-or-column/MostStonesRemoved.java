import java.util.*;

public class MostStonesRemoved {
    public static void main(String[] args) {
	    MostStonesRemoved sol = new MostStonesRemoved();
		int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
		int res = sol.removeStones(stones);
		System.out.println(res);
	}
	
	
    // count the number of islands
	// most stones removed = number of stones - number of islands
	// to count number of islands, we can use dfs (like flood fill)
	public int removeStones(int[][] stones) {
		if (stones == null || stones.length == 0) {
			return 0;
		}

		Set<int[]> visited = new HashSet<>();
		int numberOfIslands = 0;
		
		for (int[] st : stones) {
			if (!visited.contains(st)) {
				dfs(stones, visited, st);
				numberOfIslands++;
			}
		}

		return stones.length - numberOfIslands;
    }

	void dfs(int[][] stones, Set<int[]> visited, int[] st) {
		visited.add(st);

		for (int[] curst : stones) {
			if (!visited.contains(curst)) {

				if (st[0] == curst[0] || st[1] == curst[1]) {
					dfs(stones, visited, curst);
				}
			}
		}
	}
}
