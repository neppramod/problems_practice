import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		ListNode r = c(4);
		r.next = c(2);
		r.next.next = c(1);
		r.next.next.next = c(3);

		ListNode newNode = sol.insertionSortList(r);
		printNode(newNode);
    }

    static void printNode(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + ", ");
			cur = cur.next;
		}
    }

    static ListNode c(int v) {
		return new ListNode(v);
    }

    ListNode sorted;
    public ListNode insertionSortList(ListNode head) {
		sorted = null;
		ListNode current = head;

		while (current != null) {
			ListNode next = current.next;
			sortedInsert(current);
			current = next;
		}
		return sorted;
    }

    void sortedInsert(ListNode newNode) {
		if (sorted == null || sorted.val >= newNode.val) {
			newNode.next = sorted;
			sorted = newNode;
		} else {
			ListNode current = sorted;

			while (current.next != null && current.next.val < newNode.val) {
				current = current.next;
			}

			newNode.next = current.next;
			current.next = newNode;
		}
    }

    static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
