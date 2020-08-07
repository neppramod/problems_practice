import java.util.*;


class Solution {

	public static void main(String[] args) {
		int[][] graph = {{1, 2}, {3}, {3}, {}};
		Solution sol = new Solution();
		List<List<Integer>> result = sol.allPathsSourceTarget(graph);
		System.out.println(result);
	}
	
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result = new ArrayList<>();
		Deque<Integer> deque = new LinkedList<>();
		deque.add(0);
		dfs(result, deque, 0, graph.length-1, graph);
		
		return result;
    }

	void dfs(List<List<Integer>> result, Deque<Integer> deque, int cur, int dest, int[][] graph) {
		if (cur == dest) {
			result.add(new ArrayList<>(deque));
		} else {
			for (int n : graph[cur]) {
				deque.add(n);
				dfs(result, deque, n, dest, graph);
				deque.removeLast();
			}
		}
	}

}
