import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {1};

        ListNode r = c(1);
        r.next = c(2);
        r.next.next = c(3);
        r.next.next.next = c(4);
        r.next.next.next.next = c(5);
        r.next.next.next.next.next = c(6);

        printList(r);
        ListNode reverse = reverseList(r);
        printList(reverse);


    }

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
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
