class Add1
{
	class Node
	{
		int data;
		Node next;
	}

	Node addOne(Node head)
	{
		int carry = addWithCarry(head);

		if (carry > 0) {
			Node node = new Node();
			node.data = carry;
			node.next = head;
			return node;
		}

		return head;
	}

	int addWithCarry(Node head)
	{
		if (head == null)
			return 1;

		int result = head.data + addWithCarry(head.next);
		head.data = result % 10;
		return result/10;
	}

	void printNode(Node head)
	{	
		if (head == null)
			return;

		System.out.print(" -> " + head.data);
		printNode(head.next);
	}

	public static void main(String[] args)
	{
		Add1 add1 = new Add1();
		Add1.Node head = add1.new Node();
		head.data = 9;

		
		head.next = add1.new Node();
		head.next.data = 9;
		
		head.next.next = add1.new Node();
		head.next.next.data = 9;

		add1.printNode(head);
		System.out.println();
		head = add1.addOne(head);
		add1.printNode(head);
	}
}
