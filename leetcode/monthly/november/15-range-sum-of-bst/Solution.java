import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		TreeNode r = c(10);
		r.left = c(5);
		r.left.left = c(3);
		r.left.right = c(7);
		r.right = c(15);
		r.right.right = c(18);

		int answer = sol.rangeSumBST(r, 7, 15);
		System.out.println(answer);
	}

	static TreeNode c(int val) {
		return new TreeNode(val);
	}

	// In a BST we can immediately return if left is less than low
	// And if right is more than high, sum everything in between
    public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		} else if (root.val < low) {
			return rangeSumBST(root.right, low, high);
		} else if (root.val > high) {
			return rangeSumBST(root.left, low, high);
		} else {
			return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
		}
    }

	public static class TreeNode {
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
}
