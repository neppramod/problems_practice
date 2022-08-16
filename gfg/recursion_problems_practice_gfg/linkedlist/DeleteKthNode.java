import java.util.*;

public class DeleteKthNode {
    public static void main(String[] args) {
	    DeleteKthNode sol = new DeleteKthNode();
		Node r = c(9);
        r.next = c(8);
        r.next.next = c(3);
        r.next.next.next = c(5);
        r.next.next.next.next = c(2);
        r.next.next.next.next.next = c(1);
        int k = 4;
        sol.deleteNode(r, k);
        sol.printList(r);
	}
	
    static Node c(int v) {
        return new Node(v);
    }

    void deleteNode(Node r, int k) {
        if (r == null || r.next == null) {
            return;
        } else if (k == 2) {
            r.next = r.next.next;
        } else {
            deleteNode(r.next, k - 1);
        }
    }

    void printList(Node r) {
        if (r != null) {
            System.out.printf(r.val + " -> ");
            printList(r.next);
        }
    }

    static class Node {
        int val;
        Node next;

        public Node(int v) {
            val = v;
        }
    }
}





