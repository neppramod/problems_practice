package linkedlist.removelinkedlistelements;

public class RemoveLinkedListElements {
    
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        
        ListNode l = new ListNode(0);
        l.next = head;

        ListNode lh = l;

        while (l.next != null) {
            if (l.next != null && l.next.val == val) {
                l.next = l.next.next;
            } else if (l.next != null) {
                l = l.next;
            }
        }

        return lh.next;
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
