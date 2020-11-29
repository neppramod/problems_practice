import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
	ListNode r = c(1);


	int result = sol.getDecimalValue(r);
	System.out.println(result);

    }

    static ListNode c(int v) {
	return new ListNode(v);
    }

    static class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public int getDecimalValue(ListNode head) {
	int result = 0;
	while (head != null) {
	    result = result * 2 + head.val;
	    head = head.next;
	}

	return result;

    }
}
