package linkedlist.addtwonumbers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import linkedlist.addtwonumbers.AddTwoNumbers.ListNode;

public class AddTwoNumbersTest {

    /*
    Input: (2 ->4 ->3) + (5 ->6 ->4) Output: 7 ->0 ->8  
    */
    @Test
    public void testSimple() {
        AddTwoNumbers twoNumbers = new AddTwoNumbers();
        ListNode l1 = c(2);
        l1.next = c(4);
        l1.next.next = c(3);

        ListNode l2 = c(5);
        l2.next = c(6);
        l2.next.next = c(4);

        ListNode result = twoNumbers.addTwoNumbers(l1, l2);
        
        assertThat(result.val, is(7));
        assertThat(result.next.val, is(0));
        assertThat(result.next.next.val, is(8));
    }

    static ListNode c(int v) {
        return new ListNode(v);
    }
}
