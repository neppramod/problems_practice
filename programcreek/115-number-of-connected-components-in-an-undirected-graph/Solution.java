import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
		int n = 5;

		int result = sol.getConnectedCompoenents(edges, n);
		System.out.println(result);
    }

	int getConnectedCompoenents(int[][] edges, int n) {
		int count = n;
		int[] root = new int[n];

		for (int i = 0; i < n; i++) {
			root[i] = i;    // initialize root of each node as itself
		}

		for (int[] edge : edges) {
			int x = edge[0];
			int y = edge[1];

			int xRoot = find(root, x);
			int yRoot = find(root, y);

			if (xRoot != yRoot) {
				count--;
				root[xRoot] = yRoot;
			}
		}

		return count;
	}

	int find(int[] root, int i) {
		if (i == root[i]) {
			return i;
		}

		return find(root, root[i]);
	}
}
