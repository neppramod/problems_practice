import java.util.*;

/*
  Delete a linked list (whole) using recursion
 */

public class DeleteALinkedList {
    public static void main(String[] args) {
	    DeleteALinkedList sol = new DeleteALinkedList();
		Node n = new Node(2);
        insertAtEnd(n, 3);
        insertAtEnd(n, 4);
        printNode(n);
        n = deleteNode(n);
        printNode(n);
	}

    static Node deleteNode(Node n) {
        if (n == null) {
            return null;
        } else if (n.next == null) {
            return null;
        } else {
            return deleteNode(n.next);
        }
    }

     static Node insertAtEnd(Node r, int v) {
        if (r == null) {
            return new Node(v);
        } else {
            r.next = insertAtEnd(r.next, v);
            return r;
        }
    }

    static void printNode(Node n) {
        if (n == null) {
            System.out.println();
            return;
        } else {
            System.out.printf(n.val + " ");
            printNode(n.next);
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


