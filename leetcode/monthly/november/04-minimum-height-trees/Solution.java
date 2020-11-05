import java.util.*;

class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 6;
		int[][] edges = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };
		System.out.println(sol.findMinHeightTrees(n, edges));

	}
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> result = new ArrayList<>();
		if (n == 0) {
			return result;
		}

		if (n == 1) {
			result.add(0);
			return result;
		}

		// Create a graph (list of set)
		// This will help us add undirected edges and remove them as we use them
		ArrayList<HashSet<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new HashSet<Integer>());
		}

		// add both edge nodes to graph
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		LinkedList<Integer> leaves = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (graph.get(i).size() == 1) {
				leaves.add(i);
			}
		}

		if (leaves.size() == 0) {
			return result;
		}

		while (n > 2) {
			n = n - leaves.size();
			LinkedList<Integer> newLeaves = new LinkedList<>();

			for (int leave : leaves) {
				int neighbor = graph.get(leave).iterator().next();
				graph.get(neighbor).remove(leave);

				if (graph.get(neighbor).size() == 1) {
					newLeaves.add(neighbor);
				}
			}

			leaves = newLeaves;
		}

		return leaves;
	}
}
