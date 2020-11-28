package linkedlist.reversenodesinkgroup;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode prev = fake;

        int i = 0;
        ListNode p = head;

        while (p != null) {
            i++;

            if (i % k == 0) {
                prev = reverse(prev, p.next);
                p = prev.next;
            } else {
                p = p.next;
            }
        }

        return fake.next;
    }

    private ListNode reverse(ListNode prev, ListNode next) {
       ListNode p1 = prev.next;
       ListNode p2 = p1.next;

       while (p2 != next) {
           ListNode t = p2.next;
           p2.next = p1;
           p1 = p2;
           p2 = t;
       }

       ListNode prevNode = prev.next;
       prev.next.next = next;
       prev.next = p1;

       return prevNode;
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
