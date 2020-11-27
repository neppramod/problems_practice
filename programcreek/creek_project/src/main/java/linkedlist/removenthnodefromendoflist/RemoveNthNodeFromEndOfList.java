package linkedlist.removenthnodefromendoflist;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // if fast is null, remove first node (as fast reached end)
        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

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
