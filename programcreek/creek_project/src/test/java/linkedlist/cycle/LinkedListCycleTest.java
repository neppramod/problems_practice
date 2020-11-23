package linkedlist.cycle;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import linkedlist.cycle.LinkedListCycle.ListNode;

public class LinkedListCycleTest {
    
    @Test
    public void testHasCycle() {
        LinkedListCycle linkedListCycle = new LinkedListCycle();

        ListNode r = c(1);
        ListNode two = c(2);
        r.next = two;
        r.next.next = c(3);
        r.next.next.next = c(4);
        r.next.next.next.next = c(5);
        r.next.next.next.next.next = two;

        assertThat(linkedListCycle.hasCycle(r), is(true));
    }

    static ListNode c(int v) {
        return new ListNode(v);
    }
}
