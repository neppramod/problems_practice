import java.util.*;

class NextNodeInTree
{
    static class Node {
	Node left;
	Node right;
	int data;

	public Node(int data) { this.data = data;}
    }

    static void nextNodeInTree(Node root, Node currentNode)
    {
	if (root == null || currentNode == null) {
	    return;
	}

	Queue<Node> queue = new LinkedList<>();
	queue.add(root);

	while(!queue.isEmpty()) {
	    Node node = queue.poll();

	    if (node == currentNode) {
		Node nextNode = queue.peek();
		if (nextNode == null) {
		    System.out.println("Next is null");
		} else {
		    System.out.println("Next of " + node.data + " = " + nextNode.data);
		}
		return;
	    } else {
		queue.add(node.left);
		queue.add(node.right);
	    }
	}

    }


    public static void main(String[] args)
    {
	Node root = new Node(1);
	root.left = new Node(2);
	root.right = new Node(3);
	root.left.left = new Node(4);
	Node five = new Node(5);
	root.left.right = five; //new Node(5);
	root.right.left = new Node(6);
	root.right.right = new Node(7);
	root.right.right.right = new Node(8);
	root.right.right.right.right = new Node(9);
	
	nextNodeInTree(root, five);
    }
}
