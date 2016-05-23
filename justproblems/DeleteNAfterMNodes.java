public class DeleteNAfterMNodes
{
    class Node
    {
	Node next;
	int data;
    }
    
    void delete(Node root, int afterNodes, int deleteNumberOfNodes)
    {
	int escapeCount = 1;
	Node current = root;

	while (current != null && escapeCount < afterNodes) {
	    escapeCount++;
	    current = current.next;
	}

	if (current == null)
	    return;
	
	int deleteNodesCount = 0;
	Node deleteNodes = current.next;
	while (deleteNodes != null && deleteNodesCount < deleteNumberOfNodes) {
	    deleteNodesCount++;
	    deleteNodes = deleteNodes.next;
	}

	current.next = deleteNodes;

	// Keep on doing this after every afterNodes
	if (current.next != null)
	    delete(current.next, afterNodes, deleteNumberOfNodes);
    }

    void print(Node root)
    {
	if (root == null)
	    return;
	
	Node current = root;
	System.out.print(current.data);
	
	current = current.next;
	while (current != null) {
	    System.out.print(" -> " + current.data);
	    current = current.next;
	}
    }

    void add(Node root, int data)
    {
	Node current = root;
	while(current.next != null) {
	    current = current.next;
	}

        current.next = new Node();
	current.next.data = data;
    }

    public static void main(String[] args)
    {
	DeleteNAfterMNodes dm = new DeleteNAfterMNodes();
	DeleteNAfterMNodes.Node root = dm.new Node();
	root.data = 1;
	dm.add(root, 2);
	dm.add(root, 3);
	dm.add(root, 4);
	dm.add(root, 5);
	dm.add(root, 6);
	dm.add(root, 7);
	dm.add(root, 8);
	dm.add(root, 9);
	dm.add(root, 10);
						

	dm.print(root);
	System.out.println();

	dm.delete(root, 1, 1);
	dm.print(root);
    }
}
