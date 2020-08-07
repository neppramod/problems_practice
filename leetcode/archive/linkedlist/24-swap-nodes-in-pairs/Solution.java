import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        ListNode h = c(1);
        h.next = c(2);
        h.next.next = c(3);
        h.next.next.next = c(4);

        printNode(h);
        System.out.println();
        ListNode n = swapPairs(h);
        printNode(n);
    }


    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmp = head.next;
        head.next = swapPairs(head.next.next);
        tmp.next = head;
        return tmp;
    }

    static void printNode(ListNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printNode(root.next);
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static ListNode c(int x) {
        ListNode node = new ListNode(x);
        return node;
    }

}
