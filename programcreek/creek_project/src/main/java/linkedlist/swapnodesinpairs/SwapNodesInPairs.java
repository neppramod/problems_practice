package linkedlist.swapnodesinpairs;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode h = new ListNode(0);
        h.next = head;

        ListNode p1 = head;
        ListNode p2 = head.next;

        ListNode pre = h;

        while (p1 != null && p2 != null) {
            pre.next = p2;
            ListNode t = p2.next;
            p2.next = p1;

            pre = p1;
            p1.next = t;
            p1 = t;

            if (t != null) {
                p2 = t.next;
            }
        }

        return h.next;
    }

    /*
        0->1->2->3->4
        0->2->1->4->3
    */

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
