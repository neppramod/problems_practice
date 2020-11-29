import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int[] arr = { 3, 0, 2, 1, 2 };
		int start = 2;
		boolean result = sol.canReach(arr, start);
		System.out.println(result);
	}
	
    public boolean canReach(int[] arr, int start) {
		if (arr == null || arr.length == 0) {
			return false;
		}

		int n = arr.length;
		boolean[] visited = new boolean[n];

		return canReach(arr, start, visited);
    }

	boolean canReach(int[] arr, int start, boolean[] visited) {
		int n = arr.length;

		if (start < 0 || start >= n) {
			return false;
		}

		// if this node is already visited, and we did not get an answer, we don't
		// have an anser
		if (visited[start]) {
			return false;
		}

		visited[start] = true;

		if (arr[start] == 0) {
			return true;
		}

		return canReach(arr, start - arr[start], visited) || canReach(arr, start + arr[start], visited);
	}
}
