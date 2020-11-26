package linkedlist.reverselinkedlistii;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import linkedlist.reverselinkedlistii.ReverseLinkedListII.ListNode;



public class ReverseLinkedListIITest {
    
    @Test
    public void testValidNode() {
        ListNode ln = c(1);
        ln.next = c(2);
        ln.next.next = c(3);
        ln.next.next.next = c(4);
        ln.next.next.next.next = c(5);

        ListNode rs = new ReverseLinkedListII().reverseBetween(ln, 2, 4);
        assertThat(rs.val, is(1));
        assertThat(rs.next.val, is(4));
        assertThat(rs.next.next.val, is(3));
        assertThat(rs.next.next.next.val, is(2));
        assertThat(rs.next.next.next.next.val, is(5));
        assertThat(rs.next.next.next.next.next, is(nullValue()));
    }
    
    static ListNode c(int v) {
        return new ListNode(v);
    }
}
