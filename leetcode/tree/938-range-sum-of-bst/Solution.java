/*

  **
  * Definition for a binary tree node.
  * public class TreeNode {
  *     int val;
  *     TreeNode left;
  *     TreeNode right;
  *     TreeNode(int x) { val = x; }
  * }

  Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
  Output: 32

 */
class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        } else if (root.val >= L && root.val <= R) {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        } else {
            return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
    }

    public static void main(String[] args) {
        //int[] arr = {10, 5, 15, 3, 7, null, 18};
        int L = 7, R = 15;

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = null;
        root.right.right = new TreeNode(18);

        int result = new Solution().rangeSumBST(root, L, R);
        System.out.println(result);
    }

}
