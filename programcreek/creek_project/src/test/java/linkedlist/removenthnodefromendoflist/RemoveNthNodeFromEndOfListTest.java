package linkedlist.removenthnodefromendoflist;

import linkedlist.removenthnodefromendoflist.RemoveNthNodeFromEndOfList.ListNode;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class RemoveNthNodeFromEndOfListTest {
    @Test
    public void testRemoveNthNodeFromEnd() {
        ListNode ln = c(1);
        ln.next = c(2);
        ln.next.next = c(3);
        ln.next.next.next = c(4);

        ListNode rs = new RemoveNthNodeFromEndOfList().removeNthFromEnd(ln, 2);
        assertThat(rs.next.next.val, is(4));
    }

    static ListNode c(int v) {
        return new ListNode(v);
    }
}