public class Node
{
	int data;
	Node next;
	public Node(int d) { data = d; }
    public Node(){}
	
	public static Node getNode()
	{
		Node n = new Node(5);
        n.next = new Node(5);
        n.next.next = new Node(7);
        n.next.next.next = new Node(5);
        n.next.next.next.next = new Node(2);
        return n;
	}
	
	public static void print(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }

        System.out.println();
    }
}
