import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		ListNode r = c(1);

		ListNode res = sol.detectCycle(r);
		System.out.println(res);
    }

	static ListNode c(int v) {
		return new ListNode(v);
	}

    public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				slow = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}

				return slow;
			}
		}

		return null;

    }

  static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }

	  @Override
	  public String toString() {
			return String.valueOf(val);
	  }
  }
}
