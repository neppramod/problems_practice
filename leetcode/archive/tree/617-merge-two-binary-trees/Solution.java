import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        TreeNode r1 = c(1);
        r1.left = c(3);
        r1.left.left = c(5);
        r1.right = c(2);

        TreeNode r2 = c(2);
        r2.left = c(1);
        r2.left.right = c(4);
        r2.right = c(3);
        r2.right.right = c(7);

        //printTree(r2);
        TreeNode mergedTrees = new TreeNode(0);
        mergeTrees(mergedTrees, r1, r2);
        printTree(r1);
        System.out.println();
        printTree(r2);
        System.out.println();
        printTree(mergedTrees);
        System.out.println();

        TreeNode r4 = c(3);
        r4.left = c(4);
        r4.left.left = c(5);
        r4.left.right = c(4);
        r4.right = c(5);
        r4.right.right = c(7);
        printTree(r4);

        // check for null also, when both r1 and r2 are null
    }

    static void mergeTrees(TreeNode n, TreeNode r1, TreeNode r2) {
        if (r1 != null) {
            n.val += r1.val;
        }

        if (r2 != null) {
            n.val += r2.val;
        }

        TreeNode r1L = r1 != null ? r1.left : null;
        TreeNode r2L = r2 != null ? r2.left : null;
        TreeNode r1R = r1 != null ? r1.right : null;
        TreeNode r2R = r2 != null ? r2.right : null;

        if (r1L != null || r2L != null) {
            n.left = new TreeNode(0);
            mergeTrees(n.left, r1L, r2L);
        }

        if (r1R != null || r2R != null) {
            n.right = new TreeNode(0);
            mergeTrees(n.right, r1R, r2R);
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
