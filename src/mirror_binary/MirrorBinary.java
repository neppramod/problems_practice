package mirror_binary;

import tree.TreeNode;

public class MirrorBinary {
    public static void invert(TreeNode treeNode)
    {
        if (treeNode == null)
            return;

        invert(treeNode.left);
        invert(treeNode.right);

        // swap
        TreeNode tmp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = tmp;
    }

    public static void print(TreeNode treeNode)
    {
        // pre-order
        if (treeNode == null)
            return;
        print(treeNode.left);
        System.out.print(treeNode.val + " ");
        print(treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 3;

        TreeNode tmp = new TreeNode();
        tmp.val = 5;
        root.left = tmp;

        TreeNode tmp1 = new TreeNode();
        tmp1.val = 6;
        root.right = tmp1;

        TreeNode tmp2 = new TreeNode();
        tmp2.val = 2;
        tmp1.right = tmp2;

        print(root);
        invert(root);
        System.out.println("\nAfter inverting");
        print(root);
    }
}
