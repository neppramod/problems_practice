import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        TreeNode r1 = c(1);
        r1.left = c(1);
        r1.left.left = c(1);
        r1.left.right = c(1);
        r1.right = c(1);

        boolean univalue = isUnivalTree(r1);
        System.out.println(univalue);
    }

    static public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isUnivalTree(root, root.val);
    }

    static boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) {
            return true;
        } else if (root.val != val) {
            return false;
        } else {
            return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
        }
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
