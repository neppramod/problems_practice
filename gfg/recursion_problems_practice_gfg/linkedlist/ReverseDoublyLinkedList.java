import java.util.*;

public class ReverseDoublyLinkedList {
    public static void main(String[] args) {
	    ReverseDoublyLinkedList sol = new ReverseDoublyLinkedList();
        Node n = new Node(2);
        add(n, 3);
        add(n, 4);
        add(n, 5);
        printNode(n);
        Node n1 = sol.reverse(n);
        printNode(n1);
	}

    public Node reverse(Node n) {
        if (n == null) {
            return n;
        } else {
            Node tmp = n.next;
            n.next = n.prev;
            n.prev = tmp;

            if (tmp == null) {
                return n;
            } else {
                return reverse(tmp);
            }
        }
    }
	
    static void add(Node n, int v) {
        if (n.next == null) {
            n.next = new Node(v);
            n.next.prev = n;
        } else {
            add(n.next, v);
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
        Node prev, next;
        int val;

        public Node(int v) {
            val = v;
        }
    }
}


