package binarytree.flattenbinarytreetolinkedlist;

import java.util.Stack;

import binarytree.TreeNode;

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {

		TreeNode p = root;
		Stack<TreeNode> stack = new Stack<>();

		while (p != null || !stack.isEmpty()) {
			if (p.right != null) {
				stack.add(p.right);
			}

			if (p.left != null) {
				p.right = p.left;
				p.left = null;
			} else if (!stack.isEmpty()) {
				p.right = stack.pop();
			}

			p = p.right;
		}
	}
}
