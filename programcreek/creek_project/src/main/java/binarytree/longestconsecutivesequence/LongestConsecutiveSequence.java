package binarytree.longestconsecutivesequence;

import binarytree.TreeNode;

public class LongestConsecutiveSequence {

	int max = 0;
	
	public int longestConsecutive(TreeNode root) {
		dfs(root, 9999999, 0);
		return this.max;
	}

	void dfs(TreeNode root, int pre, int k) {
		if (root == null) {
			return;
		}

		if (root.val - pre != 1) {
			k = 1;
		} else {
			k++;
		}

		max = Math.max(max, k);
		dfs(root.left, root.val, k);
		dfs(root.right, root.val, k);
	}
}
