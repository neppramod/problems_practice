import java.util.*;

public class InsertTraverse {
    public static void main(String[] args) {
	    InsertTraverse sol = new InsertTraverse();
        Node r = c(9);
        r.next = c(8);
        r.next.next = c(3);
        r.next.next.next = c(5);
        r.next.next.next.next = c(2);
        r.next.next.next.next.next = c(1);
        sol.insertAtEnd(r, 21);
        sol.printList(r);
        System.out.println();
        sol.insertAtEnd(r, 32);
        sol.printList(r);
	}

    static Node c(int v) {
        return new Node(v);
    }


    void printList(Node r) {
        if (r != null) {
            System.out.printf(r.val + " -> ");
            printList(r.next);
        }
    }

    Node insertAtEnd(Node r, int v) {
        if (r == null) {
            return new Node(v);
        } else {
            r.next = insertAtEnd(r.next, v);
            return r;
        }
    }
}
