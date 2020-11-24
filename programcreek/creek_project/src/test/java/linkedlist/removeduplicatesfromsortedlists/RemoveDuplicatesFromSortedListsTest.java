package linkedlist.removeduplicatesfromsortedlists;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import linkedlist.removeduplicatesfromsortedlists.RemoveDuplicatesFromSortedLists.ListNode;

public class RemoveDuplicatesFromSortedListsTest {
    @Test
    public void testWhenListIsNotEmpty() {
        ListNode ln = c(1);
        ln.next = c(1);
        ln.next.next = c(2);

        RemoveDuplicatesFromSortedLists removeDuplicatesFromSortedLists = new RemoveDuplicatesFromSortedLists();
        ListNode result = removeDuplicatesFromSortedLists.deleteDuplicates(ln);

        assertThat(result.val, is(1));
        assertThat(result.next.val, is(2));
    }

    @Test
    public void testWhenMultipleDuplicates() {
        ListNode ln = c(1);
        ln.next = c(1);
        ln.next.next = c(2);
        ln.next.next.next = c(3);
        ln.next.next.next.next = c(3);

        RemoveDuplicatesFromSortedLists removeDuplicatesFromSortedLists = new RemoveDuplicatesFromSortedLists();
        ListNode result = removeDuplicatesFromSortedLists.deleteDuplicates(ln);

        assertThat(result.val, is(1));
        assertThat(result.next.val, is(2));
        assertThat(result.next.next.val, is(3));
    }

    static ListNode c(int v) {
        return new ListNode(v);
    }
}
