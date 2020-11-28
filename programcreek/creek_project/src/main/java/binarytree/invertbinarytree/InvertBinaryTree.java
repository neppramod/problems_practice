package binarytree.invertbinarytree;

import binarytree.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    void helper(TreeNode root) {
        if (root == null) {
            return;
        } else {
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;

            helper(root.left);
            helper(root.right);
        }
    }
}
