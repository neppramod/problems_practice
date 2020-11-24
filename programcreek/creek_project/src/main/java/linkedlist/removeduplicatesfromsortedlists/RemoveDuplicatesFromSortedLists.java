package linkedlist.removeduplicatesfromsortedlists;

public class RemoveDuplicatesFromSortedLists {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = p.next;

        while (q != null) {
            while (q != null && q.val == p.val) {
                q = q.next;
            }
            p.next = q;
            p = p.next;
        }

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
