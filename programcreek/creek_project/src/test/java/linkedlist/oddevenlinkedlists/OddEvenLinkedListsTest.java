package linkedlist.oddevenlinkedlists;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import linkedlist.oddevenlinkedlists.OddEvenLinkedLists.ListNode;

public class OddEvenLinkedListsTest {
    @Test
    public void testWhenListSizeIsMoreThanTwo() {

        OddEvenLinkedLists oddEvenLinkedLists = new OddEvenLinkedLists();
        ListNode n = c(1);
        n.next = c(2);
        n.next.next = c(3);
        n.next.next.next = c(4);
        n.next.next.next.next = c(5);

        ListNode result = oddEvenLinkedLists.oddEvenList(n);

        assertThat(result.val, is(1));
        assertThat(result.next.val, is(3));
        assertThat(result.next.next.val, is(5));
        assertThat(result.next.next.next.val, is(2));
        assertThat(result.next.next.next.next.val, is(4));
    }

    static ListNode c(int v) {
        return new ListNode(v);
    }
}
