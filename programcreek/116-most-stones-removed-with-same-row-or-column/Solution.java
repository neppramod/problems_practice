import java.util.*;
 
public class Solution
{
	// total stones - number of island
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
		int res = sol.removeStone(stones);
		System.out.println(res);
    }

	int result = 0;
	int[] root = new int[1000];
	
    public int removeStone(int[][] stones) {
		result = stones.length;
		int n = stones.length;

		for (int i = 0; i < n; i++) {
			root[i] = i;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
					union(i, j);
				}
			}
		}

		return n - result;
	}

	void union(int i, int j) {
		int ri = getRoot(root, i);
		int rj = getRoot(root, j);

		if (ri != rj) {
			root[ri] = rj;
			result--;
		}
	}

	
	int getRoot(int[] root, int i) {
		while (i != root[i]) {
			root[i] = root[root[i]];
			i = root[i];
		}

		return i;
	}
}
