import java.util.*;

class ListAtEachLevelBinaryTree
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

    static List<List<Node>> lists = new ArrayList<>();

    static void createListEachLevel(List<Node> parents)
    {	
	List<Node> nephews = new ArrayList<Node>();
	boolean allChildNull = true;

	for (Node n : parents) {
	    if (n.left != null) {
		allChildNull = false;
		nephews.add(n.left);
	    }

	    if (n.right != null) {
		allChildNull = false;
		nephews.add(n.right);
	    }
	}

	lists.add(nephews);

	if (allChildNull)
	    return;
	else {
	    createListEachLevel(nephews);
	}
    }

    public static void printList()
    {
	for (List<Node> ls : lists) {
	    for ( Node n : ls) {
		System.out.print(n.data + " -> " );
	    }
	    System.out.println();
	}
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

	List<Node> firstList = new ArrayList<>();
	firstList.add(root);
	lists.add(firstList);
	createListEachLevel(firstList);	
	printList();
    }
}
