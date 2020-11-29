import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		TreeNode root = c(1);
		root.left = c(3);
		root.left.right = c(2);
		sol.recoverTree(root);
		printTree(root);
    }

	static TreeNode c(int val) {
		return new TreeNode(val);
	}

	static void printTree(TreeNode t) {
		if (t == null) {
			return;
		}
		
		
		System.out.print(t.val + " ");			
		
		printTree(t.left);
		printTree(t.right);

	}

	// Here we cannot recursively swap values
	// Let's find 2 nodes out of place and swap the values
	TreeNode first, second, prev;
	
    public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}

		dfs(root);

		if (first != null && second != null) {
			swap(first, second);
		}
    }

	void dfs(TreeNode root) {
		if (root == null) {
			return;
		}

		// inorder
		dfs(root.left);

		// at each stage set prev to root
		if (prev == null) {
			prev = root;
		} else {
			if (root.val < prev.val) {  // if out of order (left side cannot be larger)
				if (first == null) {
					first = prev;
				}
				second = root;
			}

			prev = root;
		} 

		dfs(root.right);
	}

	void swap(TreeNode f, TreeNode s){
		int tmp = f.val;
		f.val = s.val;
		s.val = tmp;
	}



  public static class TreeNode {
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
}
