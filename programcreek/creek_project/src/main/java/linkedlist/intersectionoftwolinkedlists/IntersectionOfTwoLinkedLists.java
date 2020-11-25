package linkedlist.intersectionoftwolinkedlists;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int len1 = length(headA);
        int len2 = length(headB);

        ListNode n1 = headA;
        ListNode n2 = headB;

        if (len1 > len2) {
            int diff = len1 - len2;
            while (diff-- > 0) {
                n1 = n1.next;
            }
        } else if (len2 > len1) {
            int diff = len2 - len1;

            while (diff-- > 0) {
                n2 = n2.next;
            }
        }

        if (n1 == null || n2 == null) {
            return null;
        }

        while (n1 != null && n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        if (n1 == n2) {
            return n1;
        } else {
            return null;
        }
    }

    int length(ListNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + length(root.next);
        }
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
