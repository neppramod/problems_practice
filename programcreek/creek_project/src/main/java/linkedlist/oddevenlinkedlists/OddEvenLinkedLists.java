package linkedlist.oddevenlinkedlists;

public class OddEvenLinkedLists {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode l1 = head;
        ListNode l2 = head.next;

        ListNode connectingNode = l2;
        ListNode result = head;

        while (l1 != null && l2 != null) {
            ListNode tmp = l2.next;

            if (tmp == null) {
                break;
            }

            l1.next = l2.next;
            l1 = l1.next;

            l2.next = l1.next;
            l2 = l2.next;
        }

        l1.next = connectingNode;

        return result;
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
