import java.util.*;

class IsTreeBalanced
{
    static class Node {
	Node left;
	Node right;
	int data;

	Node(int data) { this.data = data;}
	public String toString() {
	    return this.data + "";
	}
    }

    public static int getHeight(Node root)
    {
	if (root == null)
	    return -1;

	return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static boolean isTreeBalanced(Node root)
    {
	if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
	    return false;

	return true;
    }

    

    public static void main(String[] args)
    {
	Node root = new Node(1);
	root.left = new Node(2);
	root.right = new Node(3);
	root.left.left = new Node(4);
	root.left.right = new Node(5);
	root.right.left = new Node(6);
	root.right.right = new Node(7);
	root.right.right.right = new Node(8);
	root.right.right.right.right = new Node(9);

	
	Node abc = new Node(15);
	System.out.println(getHeight(abc));
	System.out.println(getHeight(root));

	System.out.println(isTreeBalanced(root));

    }
}
