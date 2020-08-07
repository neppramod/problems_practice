import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] inorder = {9, 3, 15, 20, 7};
		int[] postorder = {9, 15, 7, 20, 3};
		TreeNode root = sol.buildTree(inorder, postorder);
		sol.printTree(root);
    }

	void printTree(TreeNode root) {
		if (root == null) {
			System.out.println("null");
		} else {
			System.out.println(root.val);
			printTree(root.left);
			printTree(root.right);
		}
	}

	static class Index {
		int index;
	}


	public TreeNode buildTree(int[] inorder, int[] postorder) {
		HashMap<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}

		Index pIndex = new Index();
		pIndex.index = postorder.length-1;
		return buildTree(inorder, postorder, 0, inorder.length-1, inMap, pIndex);
    }

	TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, HashMap<Integer, Integer> inMap, Index pIndex) {
		if (inStart > inEnd) {
			return null;
		}

		int cur = postorder[pIndex.index];
		
		
		TreeNode root = new TreeNode(cur);
		(pIndex.index)--;

		
		if (inStart == inEnd) {
			return root;
		}

		int inIndex = inMap.get(cur);


		root.right = buildTree(inorder, postorder, inIndex + 1, inEnd, inMap, pIndex);
		root.left = buildTree(inorder, postorder, inStart, inIndex-1, inMap, pIndex);

		return root;
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) { this.val = val; }
	}
}
