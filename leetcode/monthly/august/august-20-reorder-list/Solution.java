import java.util.*;

public class Solution
{
	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		sol.printList(n1);

		sol.reorderList(n1);

		sol.printList(n1);

	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}


	/*
	  Get two list using (from middle) using slow and fast algorithm
	  Reverse the second list
	  Merge both list
	*/
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode second = slow.next;
		slow.next = null;

		second = reverse(second);

		// Merge
		ListNode p1 = head;
		ListNode p2 = second;
		while (p2 != null) {
			ListNode n1 = p1.next;
			ListNode n2 = p2.next;
			p1.next = p2;
			p2.next = n1;

			p1 = n1;
			p2 = n2;
		}
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode pre = head;
		ListNode cur = head.next;

		while (cur != null) {
			ListNode n1 = cur.next;
			cur.next = pre;
			pre = cur;
			cur = n1;
		}


		head.next = null;
		return pre;
	}

	public  void printList(ListNode n) {
		System.out.println("------");
		while (n != null) {
			System.out.print(n.val);
			n = n.next;
		}
		System.out.println();
	}
}
