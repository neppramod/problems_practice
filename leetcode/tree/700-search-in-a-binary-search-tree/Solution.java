import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        TreeNode r1 = c(4);
        r1.left = c(2);
        r1.left.left = c(1);
        r1.left.right = c(3);
        r1.right = c(7);

        int search = 2;
        TreeNode findNode = findNode(r1, search);
        printTree(findNode);
    }

    static TreeNode findNode(TreeNode r1, int search) {
        if (r1 == null) {
            return null;
        } else if (r1.val == search) {
            return r1;
        } else if (search < r1.val) {
            return findNode(r1.left, search);
        } else {
            return findNode(r1.right, search);
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
