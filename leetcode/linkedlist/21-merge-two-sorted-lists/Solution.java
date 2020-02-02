import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {1};

        ListNode r = null;
//        r.next = c(2);
//        r.next.next = c(4);

        ListNode r2 = c(5);
        // r2.next = c(2);
        //r2.next.next = c(4);

        ListNode m = mergeTwoLists(r, r2);
        printList(m);
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            ListNode r1 = l1;
            ListNode r2 = l2;
            ListNode n = null;
            if (r1.val < r2.val) {
                n = r1;
                r1 = r1.next;
            } else {
                n = r2;
                r2 = r2.next;
            }
            ListNode head = n;

            while (r1 != null && r2 != null) {
                if (r1.val < r2.val) {
                    n.next = r1;
                    n = n.next;
                    r1 = r1.next;
                } else {
                    n.next = r2;
                    n = n.next;
                    r2 = r2.next;
                }
            }

            if (r1 == null) {
                n.next = r2;
            } else {
                n.next = r1;
            }

            return head;
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
