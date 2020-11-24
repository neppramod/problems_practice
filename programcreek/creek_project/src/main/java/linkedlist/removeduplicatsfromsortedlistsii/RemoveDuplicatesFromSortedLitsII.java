package linkedlist.removeduplicatsfromsortedlistsii;

public class RemoveDuplicatesFromSortedLitsII {
    
    public ListNode deleteDuplicates(ListNode head) {
        
       if (head == null || head.next == null) {
           return head;
       }

       ListNode tmp = new ListNode(0);  // dummy, to handle head duplicate
       tmp.next = head;

       ListNode p = tmp;

       while (p.next != null && p.next.next != null) {
           if (p.next.val == p.next.next.val) {
                int dup = p.next.val;

                while (p.next != null && p.next.val == dup) {
                    p.next = p.next.next;
                }
           } else {
                p = p.next;
           }
       }

       return tmp.next;
    }

    public static class ListNode {
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
