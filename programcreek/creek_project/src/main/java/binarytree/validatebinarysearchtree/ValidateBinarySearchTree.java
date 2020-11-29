package binarytree.validatebinarysearchtree;

import binarytree.TreeNode;

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}

	boolean isValidBST(TreeNode root, double min, double max) {
		if (root == null) {
			return true;
		}

		if (root.val <= min || root.val >= max) {
			return false;
		}

		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}
}
