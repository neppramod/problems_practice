package linkedlist.plusone;

public class PlusOne {

    int carry = 0;
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return new ListNode(1);
        }

        ListNode result = plusOneHelp(head);
        if (carry > 0) {
            ListNode newResult = new ListNode(carry);
            newResult.next = result;
            return newResult;
        } else {
            return result;
        }
    }

    public ListNode plusOneHelp(ListNode head) {
        if (head.next == null) {
            int sum = head.val + 1;
            head.val = sum % 10;
            carry = sum / 10;
        } else {
            ListNode next = plusOneHelp(head.next);
            int sum = carry + head.val;
            head.val = sum % 10;
            carry = sum/ 10;
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
