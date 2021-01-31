import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ListNode l1 = c(2);
        l1.next = c(4);
        l1.next.next = c(3);
        l1.next.next.next = c(9);

        ListNode l2 = c(5);
        l2.next = c(6);
        l2.next.next = c(4);

        ListNode result = addTwoNumbers(l1, l2);

        printList(result);

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        int c = 0;
        ListNode root = c(0);
        ListNode node = root;
        while (l1 != null || l2 != null) {
            node.val = c;
            node.val += l1 != null ? l1.val : 0;
            node.val += l2 != null ? l2.val : 0;
            c = node.val / 10;
            node.val = node.val % 10;
            boolean hasNext = false;
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 != null || l2 != null) {
                node.next = new ListNode(0);
                node = node.next;
            }
        }

        //System.out.println(c);
        if (c != 0) {
            node.next = new ListNode(c);
        }

        return root;
    }

    static void pA1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println();
    }

    static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pA1(arr[i]);
        }
    }
}
