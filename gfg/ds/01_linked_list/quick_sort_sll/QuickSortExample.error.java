// Error code
public class QuickSortExample
{
    Node head1;
    Node head2;
    
    static class Node
    {
        Node next;
        int data;
        Node (int d) { data = d; }
    }
    
    Node quicksort(Node l, Node h)
    {
        Node left = l;
                
        if (l == null || h == null) {
            return null;
        }
        
        if (l != h && l != null && h != null) {
            Node p = partition(l, h);
            if (p != null) {
                left = quicksort(l, p);
                Node right = quicksort(p.next, h);
                left.next = right;
            }
        }
        
        return left;
    }
    
    Node partition(Node l, Node h)
    {
        if (l == null || h == null)
            return null;
            
        Node end = h;
        Node p = h;
        int count = 0;
        for (Node j = l; j != h; j=j.next) {
            System.out.println("J : " + j.data);
            
            if (j.next != null) {
                System.out.println("J: " + j.data + ", P: " + p.data);
                if (j.data >= p.data) {
                    System.out.println("NP: " + count);
                    end.next = j;
                    System.out.println("End: " + end.data);
                    j.next = j.next.next;

                    end.next.next = null;
                                    System.out.println("What: " );
                    count++;
                            System.out.println("P: " + p.data);
                }
            }
        }
        

        return p;
    }

    void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println("");
	}

    public static void main(String[] args) {
		QuickSortExample list = new QuickSortExample();
	
		list.head1 = new Node(7);
		list.head1.next = new Node(5);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(4);
		list.head1.next.next.next.next = new Node(6);
		System.out.print("List before sort is ");
		list.printList(list.head1);

        // I am just passing the head node and the tail node.
        // Tail node can also be calculated by just traversing the linked list
		Node rev = list.quicksort(list.head1, list.head1.next.next.next.next);
		System.out.println("List after sort is ");
		list.printList(rev);
	}

    
}
