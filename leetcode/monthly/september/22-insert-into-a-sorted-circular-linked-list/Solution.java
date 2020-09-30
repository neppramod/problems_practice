import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
         
    }
    
    static class Node
	{
		public int val;
		public Node next;

		public Node(int v) {
			val = v;
		}
	}

	public Node insert(Node head, int insertVal) {
		Node newNode = new Node(insertVal);

		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}

		Node cur = head;

		while (cur.next != head && !((cur.val <= insertVal && insertVal <= cur.next.val) || (cur.val > cur.next.val && (cur.next.val > insertVal || cur.val < insertVal)))) {
			cur = cur.next;
		}

		newNode.next  = cur.next;
		cur.next = newNode;
		return head;
    }
}
