import java.util.*;

public class FindMiddle {
    public static void main(String[] args) {
	    FindMiddle sol = new FindMiddle();
        Node n = new Node(1);
        add(n, 2);
        add(n, 3);
        add(n, 4);
        add(n, 5);
        add(n, 6);
        add(n, 7);

        Node m = sol.getMid(n);
        System.out.println(m.val);
	}

    
    private Node getMid(Node n) {
        if (n == null) {
            return n;
        }
        
        Node slow = n;
        Node fast = n;

        return getMid(slow, fast);
    }


    private Node getMid(Node slow, Node fast) {
        if (fast.next == null || fast.next.next == null) {
            return slow;
        } else {
            return getMid(slow.next, fast.next.next);
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
