public class IsSubTree
{
    public static class Node
    {
	Node left;
	Node right;
	int data;

	public Node(int data) { this.data = data; }
    }
    
    public static boolean isSubTree(Node root, Node sub)
    {
	if (root == null) {
	    return false;
	} else if (root == sub) {
	    return true;
	}

	return isSubTree(root.left, sub) || isSubTree(root.right, sub);
    }

    public static void main(String[] args) {
	Node one = new Node(1);
	one.left = new Node(2);
	one.right = new Node(3);
	Node four = new Node(4);
	one.left.left = four;
	four.left = new Node(6);
	four.right = new Node(5);

	Node seven = new Node(7);

	System.out.println(isSubTree(one, seven));
	System.out.println(isSubTree(one, four));
    }
}
