import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		TreeNode r = c(3);
		r.left = c(9);
		r.right = c(20);
		r.right.left = c(15);
		r.right.right = c(7);

		int res = sol.minDepth(r);
		System.out.println(res);
    }

	static TreeNode c(int v) {
		return new TreeNode(v);
	}
    
  static class TreeNode {
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

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
            return getMinDepth(root);
        }

    }
	
	 int getMinDepth(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return 1 + getMinDepth(root.right);
        } else if (root.right == null) {
            return 1 + getMinDepth(root.left);
        } else {
            return Math.min(getMinDepth(root.left), getMinDepth(root.right)) + 1;
        }
    }
}
