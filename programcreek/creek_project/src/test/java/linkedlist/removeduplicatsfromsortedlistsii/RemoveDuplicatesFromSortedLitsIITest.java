package linkedlist.removeduplicatsfromsortedlistsii;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import linkedlist.removeduplicatsfromsortedlistsii.RemoveDuplicatesFromSortedLitsII.ListNode;

public class RemoveDuplicatesFromSortedLitsIITest {
    @Test
    public void testWhenMultipleDuplicates() {
       RemoveDuplicatesFromSortedLitsII removeDuplicatesFromSortedLitsII = new RemoveDuplicatesFromSortedLitsII();
       ListNode h = c(1);
       h.next = c(1);
       h.next.next = c(1);
       h.next.next.next = c(2);
       h.next.next.next.next = c(3);

       ListNode r = removeDuplicatesFromSortedLitsII.deleteDuplicates(h);
       assertThat(r.val, is(2));
       assertThat(r.next.val, is(3));
    }

    static ListNode c(int v) {
        return new ListNode(v);
    }
}
