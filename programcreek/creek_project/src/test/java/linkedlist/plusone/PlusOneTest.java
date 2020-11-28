package linkedlist.plusone;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import linkedlist.plusone.PlusOne.ListNode;

import org.junit.Test;

public class PlusOneTest {
    @Test
    public void testWhenNoCarry() {
        ListNode ln = c(1);
        ln.next = c(2);
        ln.next.next = c(3);

        ListNode rn = new PlusOne().plusOne(ln);
        assertThat(rn.val, is(1));
        assertThat(rn.next.val, is(2));
        assertThat(rn.next.next.val, is(4));
    }

    @Test
    public void testWhenCarry() {
        ListNode ln = c(9);
        ListNode rn = new PlusOne().plusOne(ln);

        assertThat(rn.val, is(1));
        assertThat(rn.next.val, is(0));
    }


    static ListNode c(int v) {
        return new ListNode(v);
    }
}