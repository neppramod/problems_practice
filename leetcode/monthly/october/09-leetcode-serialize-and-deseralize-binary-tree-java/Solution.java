import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
         
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
		if (root == null) {
			return "#";
		}

		Queue<TreeNode> queue = new LinkedList<>();
		List<String> list = new ArrayList<>();

		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				list.add("#");
			} else {
				list.add(cur.val + "");
				queue.add(cur.left);
				queue.add(cur.right);
			}
		}

		return String.join(",", list);
    }

	static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
		String[] arr = data.split(",");

		if (arr[0].equals("#")) {
			return null;
		}

		TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int i = 1;

		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();

			if (cur != null) {
				TreeNode left = null;

				if (!arr[i].equals("#")) {
					left = new TreeNode(Integer.parseInt(arr[i]));
				}
				cur.left = left;
				queue.add(left);
				i++;

				TreeNode right = null;
				if (!arr[i].equals("#")) {
					right = new TreeNode(Integer.parseInt(arr[i]));
				}
				cur.right = right;
				queue.add(right);
				i++;				
			}
		}

		return root;
    }
}
