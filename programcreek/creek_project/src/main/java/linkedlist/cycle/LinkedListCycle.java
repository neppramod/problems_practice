package linkedlist.cycle;


public class LinkedListCycle {

    /*
        Use fast and slow pointer tortoise-hair algorithm
    */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow  = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // otherwise infinite loop
            if (fast.next == slow) {
                return true;
            }
        }

       return false;

    }

    static class ListNode {
        int val;
        ListNode next;
    
        public ListNode(int v) {
            val = v;
        }
    }
    
}
