package linkedlist.reorderlist;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import linkedlist.reorderlist.ReorderList.ListNode;

public class ReorderListTest {

	@Test
	public void testReOrder() {
		ReorderList reorderList = new ReorderList();
		ListNode l = c(1);
		l.next = c(2);
		l.next.next = c(3);
		l.next.next.next = c(4);

		reorderList.reorderList(l);

		assertThat(l.val, is(1));
		assertThat(l.next.val, is(4));
		assertThat(l.next.next.val, is(2));
		assertThat(l.next.next.next.val, is(3));
	}

	static ListNode c(int v) {
		return new ListNode(v);
	}
}
