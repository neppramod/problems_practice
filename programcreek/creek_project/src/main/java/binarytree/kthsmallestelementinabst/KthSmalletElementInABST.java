package binarytree.kthsmallestelementinabst;

import java.util.Stack;

import binarytree.TreeNode;

public class KthSmalletElementInABST {
	
	public int kthSmallest(TreeNode root, int k) {

		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;

		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				TreeNode t = stack.pop();
				k--;
				if (k == 0) {
					return t.val;
				}

				p = t.right;
			}
		}

		return 0;
	}
}
