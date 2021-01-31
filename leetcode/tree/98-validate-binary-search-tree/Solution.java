import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TreeNode t = c(10);
        t.left = c(5);
        t.right = c(15);
        t.right.left = c(6);
        t.right.right = c(20);

        boolean result = isValidBST(t);
        System.out.println(result);

    }

    static public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    static boolean isValidBST(TreeNode root, int min, int max) {

        if (root == null) {
            return true;
        }

        if (root.val < min || root.val > max) {
            return false;
        }

        return isValidBST(root.left, min, root.val-1) && isValidBST(root.right, root.val+1, max);


    }

    static void pA1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println();
    }

    static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pA1(arr[i]);
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

    private static void printTree(TreeNode node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.val + " ");
            printTree(node.left);
            printTree(node.right);
        }
    }

}
