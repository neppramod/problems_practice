package linkedlist.mergesortedlists;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import linkedlist.mergesortedlists.MergeSortedLists.ListNode;

public class MergeSortedListsTest {
    
    @Test
    public void testWhenBothListsNotEmpty() {
        ListNode l1 = c(4);
        l1.next = c(7);
        l1.next.next = c(12);

        ListNode l2 = c(1);
        l2.next = c(8);

        MergeSortedLists mergeSortedLists = new MergeSortedLists();
        ListNode result = mergeSortedLists.mergeTwoLists(l1, l2);

        assertThat(result.val, is(1));
        assertThat(result.next.val, is(4));
        assertThat(result.next.next.val, is(7));
        assertThat(result.next.next.next.val, is(8));
        assertThat(result.next.next.next.next.val, is(12));
    }

    static ListNode c(int v) {
        return new ListNode(v);
    }
}
