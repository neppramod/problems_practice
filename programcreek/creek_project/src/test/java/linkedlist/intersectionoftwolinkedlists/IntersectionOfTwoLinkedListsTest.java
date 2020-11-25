package linkedlist.intersectionoftwolinkedlists;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import linkedlist.intersectionoftwolinkedlists.IntersectionOfTwoLinkedLists.ListNode;

public class IntersectionOfTwoLinkedListsTest {
    
    @Test
    public void testWhen1LengthDifference() {
        ListNode a1 = c(1);
        a1.next = c(2);
        

        ListNode b1 = c(1);
        b1.next = c(2);
        b1.next.next = c(3);

        ListNode c1 = c(5);
        c1.next = c(6);
        c1.next.next = c(7);

        a1.next.next = c1;
        b1.next.next.next = c1;

        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
        ListNode resultNode = intersectionOfTwoLinkedLists.getIntersectionNode(a1, b1);

        assertThat(resultNode, is(c1));
    }
    
    static ListNode c(int v) {
        return new ListNode(v);
    }
}
