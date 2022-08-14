import java.util.*;

public class PrintAlternateNodesOfLinkedList {
    public static void main(String[] args) {
	    PrintAlternateNodesOfLinkedList sol = new PrintAlternateNodesOfLinkedList();
        // Start with the empty list  
        Node head = null;  
    
        // construct below list  
        // 1.2.3.4.5.6.7.8.9.10  
    
        head = push(head, 10);  
        head = push(head, 9);  
        head = push(head, 8);  
        head = push(head, 7);  
        head = push(head, 6);  
        head = push(head, 5);  
        head = push(head, 4);  
        head = push(head, 3);  
        head = push(head, 2);  
        head = push(head, 1);  
    
        printAlternate(head);
	}
	
    static void printAlternate(Node head) {
        if (head != null) {
            System.out.printf(head.val + " ");
            if (head.next != null) {
                printAlternate(head.next.next);
            }
        } else {
            System.out.println();
        }
    }

    static Node push(Node head, int val) {
        if (head == null) {
            return new Node(val);
        } else {
            head.next = push(head.next, val);
            return head;
        }
    }
}



class Node
{
    Node next;
    int val;

    public Node(int v) {
        val = v;
    }
}
