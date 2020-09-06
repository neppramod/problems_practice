import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		TreeNode r1 = c(2);
		r1.left = c(1);
		r1.right = c(4);

		TreeNode r2 = c(1);
		r2.left = c(0);
		r2.right = c(3);
		
		List<Integer> result = sol.getAllElements(r1, r2);
		System.out.println(result);
    }

	static TreeNode c(int v) {
		return new TreeNode(v);
	}

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		inorder(root1, list1);
		inorder(root2, list2);

		list1.addAll(list2);
		Collections.sort(list1);
		return list1;
    }

	void inorder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		} else {
			inorder(root.left, list);
			list.add(root.val);
			inorder(root.right, list);
		}
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
    
}



