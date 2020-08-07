import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {1};

        ListNode r =  c(1);
        r.next = c(2);
        r.next.next = c(1);
        //r.next.next.next = c(3);
        //r.next.next.next.next = c(3);

        boolean c = isPalindrome(r);

        System.out.println(c);
    }

    public static boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode h = head;
        while (h != null) {
            stack.add(h);
            h = h.next;
        }



        ListNode j = head;
        while (j != null) {
            ListNode top = stack.pop();
            if (j.val != top.val) {
                return false;
            }
            j = j.next;
        }



        return true;
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
