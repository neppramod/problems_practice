package linkedlist.reversedoublelinkedlist;

public class ReverseDoubleLinkedList {

	public DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
		DoublyLinkedListNode p = head;
		DoublyLinkedListNode newHead = head;

		while (p != null) {
			DoublyLinkedListNode t = p.next;
			p.next = p.prev;
			p.prev = t;
			newHead = p;
			p = t;
		}

		return newHead;
	}
	
	static class DoublyLinkedListNode {
		int val;
		DoublyLinkedListNode next;
		DoublyLinkedListNode prev;

		public DoublyLinkedListNode(int v) {
			val = v;
		}

		@Override
		public String toString() {
			return String.valueOf(val);
		}
	}
}

