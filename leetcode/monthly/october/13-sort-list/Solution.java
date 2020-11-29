import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		ListNode n = new ListNode(-1);
		n.next = new ListNode(5);
		n.next.next = new ListNode(3);
		n.next.next.next = new ListNode(4);
		n.next.next.next.next = new ListNode(0);
		ListNode n1 = sol.sortList(n);

		while (n1 != null) {
			System.out.println(n1);
			n1 = n1.next;
		}
    }

	public static class ListNode
	{
		int val;
		ListNode next;
		ListNode(int val) { this.val = val; }
		public String toString() {
			return ""+ val;
		}
	}
    
    public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		} else {
			ListNode mid = getMiddle(head);
			ListNode nextOfMiddle = mid.next;
			mid.next = null;
						
			ListNode n1 = sortList(head);
			ListNode n2 = sortList(nextOfMiddle);
			return merge(n1, n2);
		}
    }

	ListNode getMiddle(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	ListNode merge(ListNode n1, ListNode n2) {
		if (n1 == null) {
			return n2;
		} else if (n2 == null) {
			return n1;
		} else {
			ListNode newHead = null;
			
			if (n1.val <= n2.val) {
				newHead = n1;
				newHead.next = merge(n1.next, n2);
			} else {
				newHead = n2;
				newHead.next = merge(n1, n2.next);
			}

			return newHead;
		}
	}
}
