import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		List<List<Integer>> answer = sol.verticalTraversal(root);
		for (List<Integer> l : answer) {
			System.out.println(l);
		}
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

	static class Od implements Comparable<Od>
	{
		int val;
		int height;

		public Od(int val, int height) {
			this.val = val;
			this.height = height;
		}

		public int compareTo(Od od1) {
			if (height == od1.height) {
				return val - od1.val;
			}
			
			return height - od1.height;
		}
	}
    
    /* Use Hashmap to track vertical index and list other. Use TreeMap to use ascending order */
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> resultList = new ArrayList<>();

		if (root == null) {
			return resultList;
		}

		TreeMap<Integer, PriorityQueue<Od>> map = new TreeMap<>();
		verticalTraversal(root, map, 0, 0);

		for (Integer key : map.keySet()) {

			List<Integer> list = new ArrayList<>();
			PriorityQueue<Od> queue = map.get(key);

			while (!queue.isEmpty()) {
				list.add(queue.poll().val);
			}
			
			resultList.add(list);
		}

		return resultList;
    }

	void verticalTraversal(TreeNode root, TreeMap<Integer, PriorityQueue<Od>> map, int verticalIndex, int height) {
		if (root == null) {
			return;
		}

		if (!map.containsKey(verticalIndex)) {
			PriorityQueue<Od> queue = new PriorityQueue<>();
			queue.add(new Od(root.val, height));
			map.put(verticalIndex, queue);
   		} else {
			PriorityQueue<Od> queue = map.get(verticalIndex);
			queue.add(new Od(root.val, height));
		}

		if (root.left != null) {
			verticalTraversal(root.left, map, verticalIndex - 1, height + 1);
		}

		if (root.right != null) {
			verticalTraversal(root.right, map, verticalIndex + 1, height + 1);
		}
	}
}
