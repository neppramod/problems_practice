package linkedlist.removelinkedlistelements;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import linkedlist.removelinkedlistelements.RemoveLinkedListElements.ListNode;


public class RemoveLinkedListElementsTest {
    
    @Test
    public void testWhenAllElementsNeedsToBeRemoved() {
        ListNode ln = c(1);
        ln.next = c(1);
        ln.next.next = c(1);

        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        ListNode result = removeLinkedListElements.removeElements(ln, 1);
        assertThat(result, is(nullValue()));
    }

    @Test
    public void testWhenFewElementsNeedToBeRemoved() {
        ListNode ln = c(1);
        ln.next = c(2);
        ln.next.next = c(3);
        ln.next.next.next = c(2);

        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        ListNode result = removeLinkedListElements.removeElements(ln, 2);

        assertThat(result.val, is(1));
        assertThat(result.next.val, is(3));
    }

    static ListNode c(int v) {
        return new ListNode(v);
    }
}
