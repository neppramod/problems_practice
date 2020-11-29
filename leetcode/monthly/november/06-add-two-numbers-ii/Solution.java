import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();

		ListNode l1 = c(7);
		l1.next = c(2);
		l1.next.next = c(4);
		l1.next.next.next = c(3);

		ListNode l2 = c(5);
		l2.next = c(6);
		l2.next.next = c(4);

		ListNode node = sol.addTwoNumbers(l1, l2);
		printList(node);
	}
	
	/**
	 * You are given two non-empty linked lists representing two non-negative numbers.
	 * The most significant digit comes froms first and each of their nodes contain a
	 * single digit. Add the two numbers and return it as a linked list.
	 * You may assume the two numbers do not contain any leading zero, except the number 0
	 * itself.
	 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: 7 -> 8 -> 0 -> 7
	 *
	 */

	static void printList(ListNode node) {
		if (node == null) {
			return;
		} else {
			System.out.print(node.val + " -> ");
			printList(node.next);
		}
	}

	static ListNode c(int val) {
		return new ListNode(val);
	}

	int carry = 0;
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int length1 = getLength(l1);
		int length2 = getLength(l2);

		if (length1 < length2) {
			l1 = prepend(0, l1, (length2 - length1));
		} else if (length2 < length1) {
			l2 = prepend(0, l2, (length1 - length2));
		}

		ListNode n1 = add(l1, l2);
		if (carry > 0) {
			n1 = prepend(carry, n1, 1);
		}
		return n1;
    }

	int getLength(ListNode node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + getLength(node.next);
		}
	}

	ListNode prepend(int val, ListNode node, int diff) {
		ListNode cur = node;
		for (int i = 0; i < diff; i++) {
			ListNode newNode = new ListNode(val);
			newNode.next = cur;
			cur = newNode;
		}

		return cur;
	}

	
	ListNode add(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		} else {
			ListNode rest = add(l1.next, l2.next);
			int sum = l1.val + l2.val + carry;
			ListNode cur = new ListNode(sum % 10);
			carry = sum / 10;
			cur.next = rest;
			return cur;
		}
	}
	

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
