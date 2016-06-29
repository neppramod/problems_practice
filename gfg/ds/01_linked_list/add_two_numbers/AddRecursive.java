public class AddRecursive
{
    Node head1;
    Node head2;
    
    static class Node
    {
        Node next;
        int data;
        Node (int d) { data = d; }
    }
    
    Node reverse(Node node)
    {
        if (node == null)
            return null;

        if (node.next == null)
            return node;

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

    Node add(Node A, Node B)
    {
        Node rA = reverse(A);
        Node rB = reverse(B);

        Node resultNode=null;
        int carry = 0;
        Node resultHead=null;

        while (rA != null || rB != null) {
            
            int result = (rA != null ? rA.data : 0) + (rB != null ? rB.data: 0) + carry;

            if (resultNode == null) {
                resultNode = new Node(result%10);
                resultHead = resultNode;
            } else {
                resultNode.next = new Node(result%10);
                resultNode = resultNode.next;
            }

            carry = result/10;

            if (rA != null)
                rA = rA.next;
            if (rB != null)
                rB = rB.next;
        }

        
        if (carry > 0) {
            resultNode.next = new Node(carry);
        }
        
        if (resultHead != null)
            return reverse(resultHead);
        else
            return null;
    }

    void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println("");
	}

    public static void main(String[] args) {
		AddRecursive list = new AddRecursive();

		// creating first list
		list.head1 = new Node(7);
		list.head1.next = new Node(5);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(4);
		list.head1.next.next.next.next = new Node(6);
		System.out.print("First List is ");
		list.printList(list.head1);

		// creating seconnd list
		list.head2 = new Node(8);
		list.head2.next = new Node(4);
		System.out.print("Second List is ");
		list.printList(list.head2);

		// add the two lists and see the result
		Node rs = list.add(list.head1, list.head2);
		System.out.print("Resultant List is ");
		list.printList(rs);
	}

    
}
