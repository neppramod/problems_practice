import java.util.*;
 
public class Solution
{
	TrieNode root;

	
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] nums = { 3, 10, 5, 25, 2, 8 };
		int res = sol.findMaximumXOR(nums);
		System.out.println(res);
    }

	public int findMaximumXOR(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		root = new TrieNode();
		for (int n : nums) {
			insert(n);
		}

		int result = 0;
		for (int n : nums) {
			result = Math.max(result, findMaximumXOR(n));
		}

		return result;
	}

	int findMaximumXOR(int num) {
		int result = 0;
		TrieNode node = root;

		for (int i = 31; i >= 0; i--) {
			int bit = (num >> i) & 1;

			if (node.get(bit ^ 1) == null) { // did not find, so get in current path
				node = node.get(bit);
			} else { // find if there is a number with 
				node = node.get(bit ^ 1);
				result = result | (1 << i);  // set ith bit				
			}
				
		}
		return result;
	}

	void insert(int num)
	{
		TrieNode node = root;
		for (int i = 31; i >= 0; i--) {
			int bit = (num >> i) & 1;

			if (node.get(bit) == null) {
				node.add(bit);
			}
			node = node.get(bit);
		}
	}

	
    
    static class TrieNode
	{
		TrieNode[] children;
		public TrieNode () {
			children = new TrieNode[2];
		}

		public TrieNode get(int i) {
			return children[i];
		}

		public void add(int i) {
			children[i] = new TrieNode();
		}
	}
}
