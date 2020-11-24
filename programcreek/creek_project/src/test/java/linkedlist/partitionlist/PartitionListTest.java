package linkedlist.partitionlist;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import linkedlist.partitionlist.PartitionList.ListNode;

public class PartitionListTest {
    
    @Test
    public void testWhenListIsNotEmpty() {
        ListNode ln = c(1);
        ln.next = c(4);
        ln.next.next = c(3);
        ln.next.next.next = c(2);
        ln.next.next.next.next = c(5);
        ln.next.next.next.next.next = c(2);

        PartitionList partitionList = new PartitionList();
        ListNode result = partitionList.partition(ln, 3);

        assertThat(result.val, is(1));
        assertThat(result.next.val, is(2));
        assertThat(result.next.next.val, is(2));
        assertThat(result.next.next.next.val, is(4));
        assertThat(result.next.next.next.next.val, is(3));
        assertThat(result.next.next.next.next.next.val, is(5));
    }

    static ListNode c(int v) {
        return new ListNode(v);
    }
}
