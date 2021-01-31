import java.util.*;

public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

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
        TreeNode r = c(2);
        r.left = c(3);
        r.left.left = c(3);
        r.left.right = c(1);
        r.right = c(1);
        r.right.right = c(1);

        Solution sol = new Solution();
        int result = sol.pseudoPalindromicPaths(r);
        System.out.println(result);
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return pseudoPalindromicPaths(root, "");
    }

    int pseudoPalindromicPaths(TreeNode root, String s) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            if (isPseudoPalindrome(s + root.val)) {
                return 1;
            } else {
                return 0;
            }
        }

        int left = pseudoPalindromicPaths(root.left, s + root.val);
        int right = pseudoPalindromicPaths(root.right, s + root.val);

        return left + right;
    }

    boolean isPseudoPalindrome(String s) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int ind = s.charAt(i) - '0';

            if (set.contains(ind)) {
                set.remove(ind);
            } else {
                set.add(ind);
            }
        }

        return set.size() == 0 || set.size() == 1;
    }
}