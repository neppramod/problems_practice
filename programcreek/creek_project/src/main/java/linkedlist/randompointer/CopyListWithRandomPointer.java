package linkedlist.randompointer;

import java.util.*;

/*
Copy nodes that has random pointer, avoid recursive cloning
*/
public class CopyListWithRandomPointer {
   
    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        // copy p node value to q
        Node p = head;
        Node q = new Node(head.val);

        map.put(p, q);

        while (p != null) {
            q.random = this.getClonedNode(p.random);
            q.next = this.getClonedNode(p.next);
            p = p.next;
            q = q.next;
        }

        return map.get(head);
    }

    public Node getClonedNode(Node node) {
        if (node != null) {
            if (map.containsKey(node)) {
                return map.get(node);
            } else {
                map.put(node, new Node(node.val));
                return map.get(node);
            }
        }

        return null;
    }

    static class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public String toString() {
            return val + (random != null ? String.valueOf(random.val) : "");
        }
    }
}
