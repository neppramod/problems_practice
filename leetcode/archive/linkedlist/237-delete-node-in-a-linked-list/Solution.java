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
        deleteNode(r.next.next.next);
        printList(r);
    }

    public static void deleteNode(ListNode node) {
        if (node.next == null) {
            return;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
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
