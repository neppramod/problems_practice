import java.util.*;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
	    CopyListWithRandomPointer sol = new CopyListWithRandomPointer();
		
	}
	
    // Definition for a Node.
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		if (head == null) {
			return head;
		}

		Map<Node, Node> map = new HashMap<>();
		Node p = head;
		Node newHead = new Node(head.val);
		Node q = newHead;

		map.put(p, q);

		p = p.next;

		while (p != null) {
			Node tmp = new Node(p.val);
			q.next = tmp;
			map.put(p, tmp);
			q = tmp;
			p = p.next;
		}

		// now set the random nodes
		p = head;
		q = newHead;

		while (p != null) {
			if (p.random != null) {
				q.random = map.get(p.random);
			}
			p = p.next;
			q = q.next;
		}

		return newHead;
	}
}
