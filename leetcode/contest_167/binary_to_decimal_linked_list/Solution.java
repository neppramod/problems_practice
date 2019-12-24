import java.util.*;

public class Solution
{

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> list = Arrays.asList(0, 0);

        ListNode head = new ListNode(list.get(0));
        ListNode listNode = head;

        for (int i = 1; i < list.size(); i++) {
            listNode.next = new ListNode(list.get(i));
            listNode = listNode.next;
        }

        System.out.println(getDecimalValue(head));
    }

    public int getDecimalValue(ListNode head) {
        int len = length(head);

        ListNode node = head;
        int pow = len-1;

        int total = 0;
        while(node != null) {
            total += node.val * Math.pow(2, pow);
            pow--;
            node = node.next;
        }

        return total;
    }

    static int length(ListNode head) {
        ListNode node = head;

        int l = 0;
        while(node != null) {
            l++;
            node = node.next;
        }

        return l;
    }
}
