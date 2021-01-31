 
import java.util.*;

public class Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
	
		if (root == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		TreeNode c = root;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(c);

		while (!q.isEmpty()) {
			TreeNode cur = q.poll();

			if (cur != null) {
				sb.append(cur.val + ",");
				q.add(cur.left);
				q.add(cur.right);
			} else {
				sb.append("#,");
			}
		}
	
		return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
			return null;
		}

		String[] split = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(split[0]));
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		int i = 1;
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			if (cur != null) {
				if (split[i].equals("#")) {
					cur.left = null;
				} else {
					cur.left = new TreeNode(Integer.parseInt(split[i]));
					q.add(cur.left);
				}
				i++;

				if (split[i].equals("#")) {
					cur.right = null;
				} else {
					cur.right = new TreeNode(Integer.parseInt(split[i]));
					q.add(cur.right);
				}
				i++;
			}
		}

		return root;	
    }
	
    static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
    }

    static TreeNode c(int v) {
		return new TreeNode(v);
    }

    static void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.val);
			inorder(root.right);
		}
    }


    public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode r = c(1);
		r.left = c(2);
		r.right = c(3);
		r.right.left = c(4);
		r.right.right = c(5);

		String serialized = sol.serialize(r);
		System.out.println(serialized);

		TreeNode deserialized = sol.deserialize(serialized);
		inorder(deserialized);
    }

}
