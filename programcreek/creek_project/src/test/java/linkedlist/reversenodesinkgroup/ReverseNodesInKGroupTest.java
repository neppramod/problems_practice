package linkedlist.reversenodesinkgroup;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import linkedlist.reversenodesinkgroup.ReverseNodesInKGroup.ListNode;


public class ReverseNodesInKGroupTest {

    @Test
    public void reverse2Group() {
        ListNode ln = c(1);
        ln.next = c(2);
        ln.next.next = c(3);
        ln.next.next.next = c(4);
        ln.next.next.next.next = c(5);

        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode lr = reverseNodesInKGroup.reverseKGroup(ln, 2);

        assertThat(lr.val, is(2));
        assertThat(lr.next.val, is(1));

        assertThat(lr.next.next.val, is(4));
    }

    static ListNode c(int v) {
        return new ListNode(v);
    }

}