package linkedlist.partitionlist;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode l1 = null;
        ListNode l2 = null;

        ListNode h1 = null;
        ListNode h2 = null;

        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                if (l1 == null) {
                    l1 = p;
                    h1 = p;
                } else {
                    l1.next = p;
                    l1 = l1.next;
                }
            } else {
                if (l2 == null) {
                    l2 = p;
                    h2 = p;
                } else {
                    l2.next = p;
                    l2 = l2.next;
                }
            }

            

            p = p.next;
        }

        l2.next = null;
        l1.next = h2;

        return h1;
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
