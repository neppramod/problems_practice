import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		TreeNode r = c(8);
		r.right = c(10);
		r.right.right = c(14);
		r.right.right.left = c(13);
		r.left = c(3);
		r.left.left = c(1);
		r.left.right = c(6);
		r.left.right.left = c(4);
		r.left.right.right = c(7);

		int result = sol.maxAncestorDiff(r);
		System.out.println(result);
	}

	static TreeNode c(int val) {
		return new TreeNode(val);
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	int result = 0;

	public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
			return 0;
		}

		dfs(root, root.val, root.val);

		return result;
    }

	void dfs(TreeNode root, int min, int max) {
		if (root == null) {
			return;
		}

		result = Math.max(result, Math.max(Math.abs(root.val - min), Math.abs(root.val - max)));
		max = Math.max(max, root.val);
		min = Math.min(min, root.val);

		dfs(root.left, min, max);
		dfs(root.right, min, max);
	}
}
