import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {1};

        ListNode r = c(1);
        r.next = c(2);
        //r.next.next = c(2);
        //r.next.next.next = c(2);
        //r.next.next.next.next = c(5);
        //r.next.next.next.next.next = c(6);
        //r.next.next.next.next.next.next = c(7);

        printList(r);
        ListNode rem = removeElements(r, 2);
        printList(rem);
    }

    /*
      1->2->6->3->4->5->6, val=6
      // First remove all the val's starting from second item
      // cleanup the first, if it has tat value at last
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode n = head;

        if (n == null) {
            return n;
        }

        while (n.next != null) {
            if (n.next.val == val) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }

        if (head.val == val) {
            if (head.next == null) {
                return null;
            }else {
                head.val = head.next.val;
                head.next = head.next.next;
            }
        }

        return head;

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
