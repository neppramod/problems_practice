package linkedlist.palindromelinkedlist;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import linkedlist.palindromelinkedlist.DeterminePalindromeLinkedList.ListNode;

import org.junit.Test;

public class DeterminePalindromeLinkedListTest {

    @Test
    public void testWhenListIsOdd() {
        DeterminePalindromeLinkedList determinePalindromeLinkedList = new DeterminePalindromeLinkedList();
        ListNode ln = c(1);
        ln.next = c(2);
        ln.next.next = c(3);
        ln.next.next.next = c(2);
        ln.next.next.next.next = c(1);

        assertThat(determinePalindromeLinkedList.isPalindrome(ln), is(true));
    }

    @Test
    public void testWhenListIsEven() {
        DeterminePalindromeLinkedList determinePalindromeLinkedList = new DeterminePalindromeLinkedList();
        ListNode ln = c(1);
        ln.next = c(2);
        ln.next.next = c(3);
        ln.next.next.next = c(3);
        ln.next.next.next.next = c(2);
        ln.next.next.next.next.next = c(1);

        assertThat(determinePalindromeLinkedList.isPalindrome(ln), is(true));

    }

    @Test
    public void testWhenListIOneSize() {
        DeterminePalindromeLinkedList determinePalindromeLinkedList = new DeterminePalindromeLinkedList();
        ListNode ln = c(1);

        assertThat(determinePalindromeLinkedList.isPalindrome(ln), is(true));
    }

    static ListNode c(int v) {
        return new ListNode(v);
    }
}