import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		TreeNode r = c(5);
		r.left = c(3);
		r.right = c(6);
		r.left.left = c(2);
		r.left.right = c(4);
		r.right.right = c(7);

		print(r);
		sol.deleteNode(r, 3);
		System.out.println("Next:===");
		print(r);
		
    }

	static void print(TreeNode r) {
		if (r == null) {
			return;
		}
		System.out.println(r.val + " ");
		print(r.left);
		print(r.right);
		
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

	static TreeNode c(int v) {
		return new TreeNode(v);
	}


	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
			return root;
		} else if (root.val > key) {
			root.left = deleteNode(root.left, key);
			return root;
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			
			// find in order successor
			root.val = minValue(root.right);
			root.right = deleteNode(root.right, root.val);
		}

		return root;
    }

	int minValue(TreeNode root) {
		int min = root.val;
		while (root.left != null) {
			min = root.left.val;
			root = root.left;
		}

		return min;
	}
}
