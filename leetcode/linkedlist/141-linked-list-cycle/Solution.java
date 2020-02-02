import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {1};

        ListNode r =  c(1);
        r.next = c(2);
        r.next.next = r;
        //r.next.next.next = c(3);
        //r.next.next.next.next = c(3);

        boolean c = hasCycle(r);

        System.out.println(c);
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        } else {
            ListNode slow = head;
            ListNode fast = head.next;

            while (slow != null && fast != null && fast.next != null && fast.next.next != null && slow != fast) {
                slow = slow.next;
                fast = fast.next.next;
            }

            if (slow == fast) {
                return true;
            } else {
                return false;
            }
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
