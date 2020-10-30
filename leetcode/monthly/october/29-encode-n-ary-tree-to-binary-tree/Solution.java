import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
         
    }
    
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) {
			return null;
		}

		int val = root.val;
		TreeNode rootNode = new TreeNode(val);

		if (root.children.isEmpty()) {
			return rootNode;
		}

		rootNode.left = encode(root.children.get(0));
		TreeNode cur = rootNode.left;
		for (int i = 1; i < root.children.size(); i++) {
			cur.right = encode(root.children.get(i));
			cur = cur.right;
		}

		return rootNode;
    }
	
    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) {
			return null;
		}

		Node nAryRootNode = new Node();
		nAryRootNode.children = new ArrayList<>();
		nAryRootNode.val = root.val;
		TreeNode cur = root.left;

		while (cur != null) {
			nAryRootNode.children.add(decode(cur));
			cur = cur.right;
		}

		return nAryRootNode;
    }

	// Definition for a Node.

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

 
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
