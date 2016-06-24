public class ReverseLinkedList
{
	static class Node
	{
		Node next;
		int data;
		
		public Node(int d) { this.data = d; }
	}

	public static Node reverse(Node node)
	{
		if (node == null) {
			return null;
		} else if (node.next == null){
			return node;
		} else {
			Node rev = reverse(node.next);
			node.next.next = node;
			node.next = null;
			return rev;
		}
	}
	
	public static Node reverseiter(Node node)
	{
		if (node == null) {
			return null;
		}
		
		Node prev = null;
		Node cur = node;
		
		while (cur != null) {  
			Node next = cur.next;
			cur.next = prev; 
			prev = cur;  
			cur = next;  
		}
		
		return prev;
	}
	
	public static void print(Node node)
	{
		while (node != null) {
			System.out.println(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		Node node = new Node(2);
		node.next = new Node(5);
		node.next.next = new Node(7);
		node.next.next.next = new Node(9);
		
		
		Node reversed = reverse(node);
		print(reversed);
		
		Node rev1 = reverseiter(reversed);
		print(rev1);
		
		
	}
}
