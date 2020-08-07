import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {1};

        ListNode r = c(1);
        r.next = c(2);
        r.next.next = c(3);
        r.next.next.next = c(4);
        r.next.next.next.next = c(5);
        //r.next.next.next.next.next = c(6);


        ListNode middle = middleNode(r);
        System.out.println(middle.val);

    }

    static ListNode c(int v) {
        return new ListNode(v);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else if (head.next.next == null) {
            return head.next;
        } else {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }


}
