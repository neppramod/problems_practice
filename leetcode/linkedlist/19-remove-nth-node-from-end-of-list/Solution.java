import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        ListNode h = c(1);
        // h.next = c(2);
        //h.next.next = c(3);
        //h.next.next.next = c(4);
        //h.next.next.next.next = c(5);

        printNode(h);
        System.out.println();
        removeNthFromEnd(h, 1);
        printNode(h);
        System.out.println();
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

    /*
      Find the n'th node from start
      After that loop from beginning and n'th node, while n'th node reaches end
      The start node reaches n't node from end, remove this node

      1->2->3->4->5,
n = 2
      1->2->3->5
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nthNode = head;
        int count = n;
        while (count > 0 && nthNode != null) {
            nthNode = nthNode.next;
            count--;
        }

        if (nthNode == null) {
            return head.next;
        }

        ListNode cur = head;
        while(nthNode.next != null) {
            nthNode = nthNode.next;
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return head;
    }



}
