import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {1};

        ListNode r =  c(1);
        r.next = c(2);
        r.next.next = c(1);

        ListNode r2 = c(2);
        r2.next = c(3);
        r2.next.next = r.next;

        printList(r);
        printList(r2);
        ListNode n = getIntersectionNode(r, r2);
        printList(n);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        } else {

            ListNode h1 = headA;
            ListNode h2 = headB;
            int l1 = length(h1);
            int l2 = length(h2);

            //System.out.println("L1: " + l1);
            //System.out.println("L2: " + l2);

            if (l1 > l2) {
                int diff = l1 - l2;
                for (int i = 0; i < diff; i++) {
                    h1 = h1.next;
                }
            } else if (l2 > l1) {
                int diff = l2 - l1;
                for (int i = 0; i < diff; i++) {
                    h2 = h2.next;
                }
            }

            // printList(h1);
            //printList(h2);

            while (h1 != null && h2 != null && h1 != h2) {
                //System.out.println("h1: " + h1.val + ", h2: " + h2.val);
                h1 = h1.next;
                h2 = h2.next;
            }

            //System.out.println("h1: " + h1.val + ", h2: " + h2.val);

            if (h1 == h2) {
                return h1;
            } else {
                return null;
            }
        }
    }

    public static int length(ListNode head) {
        if (head == null) {
            return 0;
        } else {
            return 1 + length(head.next);
        }
    }

    static void printList(ListNode list) {
        ListNode node = list;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    static ListNode c(int v) {
        return new ListNode(v);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
