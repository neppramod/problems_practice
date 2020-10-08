import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		ListNode n = new ListNode(1);
		n.next = new ListNode(2);
		//n.next.next = new ListNode(3);
		//n.next.next.next = new ListNode(4);
		//n.next.next.next.next = new ListNode(5);

		ListNode n1 = sol.rotateRight(n, 2);
		sol.printNode(n1);
    }

	void printNode(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + " -> ");
			cur = cur.next;
		}
		System.out.println();
	}
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
			return head;
		}

		int len = getLength(head);

		k = k % len;


		if (len == 1) {
			return head;
		}
		
		if (k == 0) {
			return head;
		}

		
		
		ListNode offset = head;
		for (int i = 0; i < k; i++) {
			offset = offset.next;
		}

		ListNode cur = head;
		while (offset != null && offset.next != null) {
			cur = cur.next;
			offset = offset.next;
		}

		offset.next = head;
		ListNode result = cur.next;
		cur.next = null;
		return result;
    }

	int getLength(ListNode head) {
		ListNode cur = head;
		int count = 0;

		while (cur != null) {
			count++;
			cur = cur.next;
		}

		return count;
	}

  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
