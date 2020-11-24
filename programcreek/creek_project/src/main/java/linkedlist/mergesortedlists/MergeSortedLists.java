package linkedlist.mergesortedlists;

public class MergeSortedLists {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head = null;

        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode p = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
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
