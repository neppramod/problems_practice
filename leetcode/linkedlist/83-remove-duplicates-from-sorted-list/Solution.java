import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {1};

        ListNode r = null;// c(1);
        //r.next = c(1);
        //r.next.next = c(2);
        //r.next.next.next = c(3);
        //r.next.next.next.next = c(3);

        ListNode d = deleteDuplicates(r);

        printList(d);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        } else {
            ListNode n = head;
            while (n.next != null) {
                while (n != null && n.next != null && n.val == n.next.val) {
                    n.next = n.next.next;
                }
                if (n.next != null) {
                    n = n.next;
                }

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
