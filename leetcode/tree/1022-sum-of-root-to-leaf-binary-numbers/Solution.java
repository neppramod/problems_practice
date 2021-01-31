import java.util.*;

public class Solution {

    public static void main(String[] args) {
        TreeNode r = c(1);
        r.left = c(0);
        r.left.left = c(0);
        r.left.right = c(1);
        r.right = c(1);
        r.right.left = c(0);
        r.right.right = c(1);

        int sum = sumRootToLeaf(r);
        System.out.println(sum);
    }

    public static int sumRootToLeaf(TreeNode root) {

        return sumRootToLeaf(root, "");

    }

    private static int sumRootToLeaf(TreeNode root, String cur) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return binToDigit(cur + root.val);
        } else {
            return sumRootToLeaf(root.left, cur+root.val) + sumRootToLeaf(root.right, cur + root.val);
        }
    }

    private static int binToDigit(String str) {
        return Integer.parseInt(str, 2);
    }



    private static void printTree(TreeNode node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.val + " ");
            printTree(node.left);
            printTree(node.right);
        }
    }



    static TreeNode c(int val) {
        return new TreeNode(val);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
