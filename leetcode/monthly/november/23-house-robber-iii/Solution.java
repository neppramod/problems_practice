import java.util.*;



public class Solution {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static TreeNode c(int val) {
        return new TreeNode(val);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode r = c(3);
        r.left = c(4);
        r.right = c(5);
        r.left.left = c(1);
        r.left.right = c(3);
        r.right.right = c(1);

        int result = sol.rob(r);
        System.out.println(result);
    }

    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    int[] helper(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int[] result = new int[2];
        result[0] = root.val + left[1] + right[1];
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return result;
    }

    
}


