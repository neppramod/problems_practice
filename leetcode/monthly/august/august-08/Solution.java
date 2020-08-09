import java.util.*;

public class Solution {
	int pathNumbers = 0;

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println("Hello World");

		System.out.println("Hello World");

		System.out.print("Hello World");
	}

	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		} else {
			helper(root, sum);
			pathSum(root.left, sum);
			pathSum(root.right, sum);

			return pathNumbers;
		}

	}

	void helper(TreeNode root, int sum) {
		if (root == null) {
			return;
		}

		if (root.val == sum) {
			pathNumbers++;
		}

		if (root != null) {
			sum -= root.val;
			helper(root.left, sum);
			helper(root.right, sum);
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
