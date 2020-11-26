package linkedlist.reverselinkedlistii;

public class ReverseLinkedListII {

    /*
        1->2->3->4->5->null
        m = 2, n = 4
        1->4->3->2->5->null
    */

    public ListNode reverseBetween(ListNode head, int m, int n) {

        // cannot reverse, if nothing to reverse
        if (m == n) {
            return head;
        }

        ListNode prev = null;               // points to (m-1)th node. 1
        ListNode first = new ListNode(0);   // next points to mth node. 2
        ListNode second = new ListNode(0); // next points to (n+1)th node. 5
        
        int count = 0;
        ListNode p = head;
        
        while (p != null) {
            count++;

            if (count == m - 1) {
                prev = p;
            }

            if (count == m) {
                first.next = p;
            }

            if (count == n) {
                second.next = p.next;
                p.next = null; // break the chain after second to handle reverse until null
            }

			p = p.next;
        }
        
        // if first.next was null, we don't have anything to handle, so return head
        if (first.next == null) {
            return head;
        }

        // Let's get p1, p2
        ListNode p1 = first.next;
        ListNode p2 = p1.next;

        // Let's link p1's next to next node after break up we did in second node
        // In the example 2->5
        p1.next = second.next;

        // Now let's incrementally handle p1 and p2 until either of them are not null
        while (p1 != null && p2 != null) {
            // p1 already knows it's next node
            // Now let's have p2 point to p1
            ListNode t = p2.next; // next of p2
            p2.next = p1;
            p1 = p2; // move p1 to p2
            p2 = t; // move p2 to next
        }
        
        // If pre was good pre->next is p1. In above loop (example) when p2 is null, p1 becomes 4. 1->4
        if (prev != null) {
            prev.next = p1;
        } else {  // if prev was null, we can return p1, as it is the starting node
            return p1;
        }

        // everything is linked properly, can return head
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
    
        public ListNode(int v) {
            val = v;
        }
    
        @Override
        public String toString() {
           return String.valueOf(val);
        }
    }
}
