import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int[] instructions = { 1, 3, 3, 3, 2, 4, 2, 1, 2 };
		int result = sol.createSortedArray(instructions);
		System.out.println(result);
	}
	
	static class Fenwick
	{
		int[] tree;

		public Fenwick(int num) {
			this.tree = new int[num + 1];
		}

		public void add(int i, int val) {
			while (i < tree.length) {
				tree[i] += val;
				i += (i & -i);
			}
		}

		public int sum(int i) {
			int sum = 0;

			while (i > 0) {
				sum += tree[i];
				i -= (i & -i);
			}

			return sum;
		}
		
	}


	static final int SIZE = 100001;
	static final int MOD = 1000000007;
	
	public int createSortedArray(int[] instructions) {
		Fenwick f = new Fenwick(SIZE);
		int ans = 0;
		
		for (int i = 0; i < instructions.length; i++) {
			ans += Math.min(f.sum(instructions[i] - 1), i - f.sum(instructions[i]));
			ans %= MOD;
			f.add(instructions[i], 1);
		}

		return ans;
	}

}
