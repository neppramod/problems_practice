package linkedlist.deletenodeinlinkedlist;

import linkedlist.deletenodeinlinkedlist.DeleteNodeInALinkedList.ListNode;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;


public class DeleteNodeInALinkedListTest {

    @Test
    public void deleteNode() {
        ListNode l1 = c(1);
        ListNode l2 = c(2);
        l1.next = l2;
        l2.next = c(3);

        DeleteNodeInALinkedList deleteNodeInALinkedList = new DeleteNodeInALinkedList();
        deleteNodeInALinkedList.deleteNode(l2);

        assertThat(l1.next.val, is(3));
    }

    static ListNode c(int v) {
        return new ListNode(v);
    }
}