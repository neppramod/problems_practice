
package myprob;

public class Node
{
	Node next;
	int data;
	
	public Node(int data) { this.data = data; }
	
	void appendToTail(int d)
	{
		Node current = this;
		while (current.next != null) {
			current = current.next;
		}
		
		current.next = new Node(d);
	}
	
	void printNode() 
	{
		Node current = this;
		while (current != null) {
			System.out.print(current.data + ", ");
			current = current.next;
		}
		System.out.println();
	}
	
	public Node delete(Node head, int d)
	{
		Node node = head;
		
		if (node == null) {
			return null;
		}
			
		if (node.data == d) {
			return node.next;
		} else {
			while (node.next != null) {
				if (node.next.data == d) {
					node.next = node.next.next;
				}
				node = node.next;
			}
		}
		
		return head;
	}
	
}
