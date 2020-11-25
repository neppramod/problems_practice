package linkedlist.swapnodesinpairs;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import linkedlist.swapnodesinpairs.SwapNodesInPairs.ListNode;

public class SwapNodesInPairsTest {
    @Test
    public void testWhenNodesAreEven() {
        ListNode ls = c(1);
        ls.next = c(2);
        ls.next.next = c(3);
        ls.next.next.next = c(4);
        ls.next.next.next.next = c(5);
        ls.next.next.next.next.next = c(6);

        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode rs = swapNodesInPairs.swapPairs(ls);

        assertThat(rs.val, is(2));
        assertThat(rs.next.val, is(1));
        assertThat(rs.next.next.val, is(4));
        assertThat(rs.next.next.next.val, is(3));
        assertThat(rs.next.next.next.next.val, is(6));
        assertThat(rs.next.next.next.next.next.val, is(5));
    }

    @Test
    public void testWhenSingleNode() {
        ListNode ls = c(1);
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode rs = swapNodesInPairs.swapPairs(ls);
        
        assertThat(rs.val, is(1));
    }

    @Test
    public void testWhenNodesAreOdd() {
        ListNode ls = c(1);
        ls.next = c(2);
        ls.next.next = c(3);

        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode rs = swapNodesInPairs.swapPairs(ls);
        
        assertThat(rs.val, is(2));        
        assertThat(rs.next.val, is(1));
        assertThat(rs.next.next.val, is(3));
    }

    static ListNode c(int v) {
        return new ListNode(v);
    }
}
