import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
         
    }
    
  public class TreeNode {
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

	 public TreeNode insertIntoBST(TreeNode root, int val) {
		 if (root == null) {
			 return new TreeNode(val);
		 }
		 
		 TreeNode cur = root;
		 insertIntoBSTHelper(cur, val);
		 return root;
	 }

	void insertIntoBSTHelper(TreeNode cur, int val) {
		if (val >= cur.val && cur.right == null) {
			cur.right = new TreeNode(val);
		} else if (val < cur.val && cur.left == null) {
			cur.left = new TreeNode(val);
		} else if (cur.right != null && val >= cur.val) {
			insertIntoBSTHelper(cur.right, val);
		} else {
			insertIntoBSTHelper(cur.left, val);
		}
	}
 
}
