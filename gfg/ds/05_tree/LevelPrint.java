public class LevelPrint
{
	public static class Node
	{
		int data;
		Node left;
		Node right;

		Node(int d) { data = d; }
	}

	public static void levelPrint(Node root, int level)
	{
		if (root == null)
			return;
		StringBuffer sb = new StringBuffer();
		for (int k = 0; k < level; k++) {
			sb.append("  ");
		}
		sb.append(root.data);
		System.out.println(sb.toString());
		levelPrint(root.left, level+1);
		levelPrint(root.right, level+1);
	}

	public static void main(String[] args)
	{
		Node node = new Node(1);
		node.left = new Node(2);
		node.left.left = new Node(3);
		node.left.right = new Node(4);
		node.left.right.right = new Node(7);
		node.left.left.left = new Node(5);
		node.left.left.right = new Node(6);

		levelPrint(node, 0);
	}

}
