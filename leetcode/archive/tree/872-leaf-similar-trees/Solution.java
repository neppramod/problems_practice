import java.util.*;

public class Solution {

    public static void main(String[] args) {
        TreeNode r = c(3);
        r.left = c(5);
        r.left.left = c(6);
        r.left.right = c(2);
        r.left.right.left = c(7);
        r.left.right.right = c(4);
        r.right = c(1);
        r.right.left = c(9);
        r.right.right = c(8);

        TreeNode r2 = null;

        boolean ls = leafSimilar(r, r2);
        System.out.println(ls);
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        processTreeNodes(sb1, root1);
        processTreeNodes(sb2, root2);

        return sb1.toString().equals(sb2.toString());
    }

    private static void processTreeNodes(StringBuilder sb, TreeNode root) {
        if (root == null) {
            return;
        } else {
            processTreeNodes(sb, root.left);

            if (root.left == null && root.right == null) {
                sb.append(root.val);
            }

            processTreeNodes(sb, root.right);
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
