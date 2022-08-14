import java.util.*;

public class AlternativeSplit {
    public static void main(String[] args) {
	    AlternativeSplit sol = new AlternativeSplit();
        Node n = new Node(1);
        add(n, 2);
        add(n, 3);
        add(n, 4);
        add(n, 5);
        add(n, 6);
        add(n, 7);

        printList(n);
        sol.splitAlternative(n);
	}

    void splitAlternative(Node n) {
        Node n1 = null, n2 = null;
        
        if (n == null) {
            return;
        } else if (n.next == null) {
            n1 = n;            
        } else {
            n1 = n;
            n2 = n.next;
            splitAlternative(n1, n2);
        }
        printList(n1);
        printList(n2);
    }

    void splitAlternative(Node n1, Node n2) {
        if (n1 == null || n2 == null) {
            return;
        } else {
            if (n1.next != null) {
                n1.next = n1.next.next;
            }

            if (n2.next != null) {
                n2.next = n2.next.next;
            }

            splitAlternative(n1.next, n2.next);
        }
    }
    
    static void add(Node n, int v) {
        if (n.next == null) {
            n.next = new Node(v);
        } else {
            add(n.next, v);
        }
    }

    static void printList(Node n) {
        if (n == null) {
            System.out.println();
        } else {
            System.out.printf(n.val + " ");
            printList(n.next);
        }
    }
    
}

class Node {
    Node next;
    int val;

    public Node(int v) {
        val = v;
    }
}
