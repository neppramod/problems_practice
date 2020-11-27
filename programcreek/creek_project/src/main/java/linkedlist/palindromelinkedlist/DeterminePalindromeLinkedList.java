package linkedlist.palindromelinkedlist;

public class DeterminePalindromeLinkedList {
    // break and reverse second half
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        // reverse second list
        ListNode pre = null;
        ListNode p = secondHead;
        ListNode next = null;

        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        secondHead.next = null;

        p = head;

        while (p != null && pre != null) {
            if (p.val != pre.val) {
                return false;
            }
            p = p.next;
            pre = pre.next;
        }

        return true;

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
