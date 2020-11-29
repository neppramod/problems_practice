package linkedlist.reversedoublelinkedlist;

import linkedlist.reversedoublelinkedlist.ReverseDoubleLinkedList.DoublyLinkedListNode;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;


public class ReverseDoubleLinkedListTest {

	@Test
	public void testWhenListIsValid() {
		DoublyLinkedListNode l1 = c(1);
		DoublyLinkedListNode l2 = c(2);
		DoublyLinkedListNode l3 = c(3);

		l1.next = l2;
		l2.prev = l1;

		l2.next = l3;
		l3.prev = l2;

		DoublyLinkedListNode rl = new ReverseDoubleLinkedList().reverse(l1);

		assertThat(rl.val, is(3));
		assertThat(rl.next.val, is(2));
		assertThat(rl.next.next.val, is(1));
		assertThat(rl.prev, is(nullValue()));
		assertThat(rl.next.prev.val, is(3));
		assertThat(rl.next.next.prev.val, is(2));
	}
	
	static DoublyLinkedListNode c(int v) {
		return new DoublyLinkedListNode(v);
	}
}
