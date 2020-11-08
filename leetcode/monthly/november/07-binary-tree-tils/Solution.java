import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		TreeNode r = c(4);
		r.left = c(2);
		r.right = c(9);
		r.left.left = c(3);
		r.left.right = c(5);
		r.right.right = c(7);
		
		int result = sol.findTilt(r);
		System.out.println(result);
	}


	static TreeNode c(int v) {
		return new TreeNode(v);
	}
	


	public int findTilt(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int left = getSum(root.left);
			int right = getSum(root.right);

			int tilt = Math.abs(left - right);
			return tilt + findTilt(root.left) + findTilt(root.right);
		}
    }

	public int getSum(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return root.val + getSum(root.left) + getSum(root.right);
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
