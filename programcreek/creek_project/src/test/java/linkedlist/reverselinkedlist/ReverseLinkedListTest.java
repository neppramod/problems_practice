package linkedlist.reverselinkedlist;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import linkedlist.reverselinkedlist.ReverseLinkedList.ListNode;


public class ReverseLinkedListTest {
    @Test
    public void testWhenListIsValid() {
        ListNode l = c(1);
        l.next = c(2);
        l.next.next = c(3);

        ListNode r = new ReverseLinkedList().reverseList(l);

        assertThat(r.val, is(3));
        assertThat(r.next.val, is(2));
        assertThat(r.next.next.val, is(1));
    }   
    
    static ListNode c(int v) {
        return new ListNode(v);
    }
}
