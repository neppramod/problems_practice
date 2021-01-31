import java.util.*;

public class MergeKSortedLists {
    public static void main(String[] args) {
	    MergeKSortedLists sol = new MergeKSortedLists();
		ListNode l1 = c(1);
		l1.next = c(4);
		l1.next.next = c(5);

		ListNode l2 = c(1);
		l2.next = c(3);
		l2.next.next = c(4);

		ListNode l3 = c(2);
		l3.next = c(6);

		ListNode[] lists = new ListNode[3];
		lists[0] = l1;
		lists[1] = l2;
		lists[2] = l3;

		ListNode r = sol.mergeKLists(lists);
		while (r != null) {
			System.out.println(r.val);
			r = r.next;
		}
	}

	static ListNode c(int v) {
		return new ListNode(v);
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		@Override
		public String toString() {
			return String.valueOf(val);
		}
		
	}

	static class Pair implements Comparable<Pair>
	{
		ListNode n;
		int index;

		public Pair(ListNode n1, int in1) {
			n = n1;
			index = in1;
		}

		@Override
		public int compareTo(MergeKSortedLists.Pair o) {
			return n.val - o.n.val;
		}
	}
	
    public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) {
			return null;
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		ListNode dummy = new ListNode(-1);
		ListNode root = dummy;
		ListNode cur = root;

		// add first elements along with their indices from each list
		for (int k = 0; k < lists.length; k++) {
			if (lists[k] != null) {
				pq.add(new Pair(lists[k], k));
			}
		}

		// now we process until pq is empty
		while (!pq.isEmpty()) {
			Pair curPair = pq.poll();
			cur.next = curPair.n;
			cur = cur.next;

			if (curPair.n.next != null) {
				curPair.n = curPair.n.next;
				pq.add(curPair);
			}
		}

		return root.next;
    }
}
