package linkedlist.reorderlist;

public class ReorderList {
	/*
	  Change list from L0 -> L1 -> ... Ln-1 -> Ln
	
	  to L0 -> Ln -> l1 -> Ln-1 -> ...
	
	in place
	
	Break list into two halves, reverse second and merge two
	 */

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int v) {
			val = v;
		}
	}

	public void reorderList(ListNode root) {
		if (root == null || root.next == null) {
			return;
		}

		ListNode l1 = root;
		ListNode slow = root;
		ListNode fast = root;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode mid = slow.next;
		slow.next = null;

		ListNode revmid = reverse(mid);
		ListNode merged = merge(root, revmid);
		root = merged;
	}

	ListNode merge(ListNode l1, ListNode l2) {
		ListNode r = l1;
		while (l1 != null && l2 != null) {
			ListNode n1 = l1.next;
			ListNode n2 = l2.next;

			l1.next = l2;
			l2.next = n1;
			l1 = n1;
			l2 = n2;
		}

		return r;
	}

	ListNode reverse(ListNode r) {
		if (r == null || r.next == null) {
			return r;
		}

		ListNode next = null;
		ListNode cur = r;
		ListNode prev = null;

		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		return prev;
	}
}
