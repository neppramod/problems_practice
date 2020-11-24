package linkedlist.randompointer;

import linkedlist.randompointer.CopyListWithRandomPointer.Node;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class CopyListWithRandomPointerTest {

    @Test
    public void testCopyRandomList() {
        Node seven = c(7);
        Node thirteen = c(13);
        Node eleven = c(11);
        Node ten = c(10);
        Node one = c(1);

        seven.next = thirteen;

        thirteen.random = seven;
        thirteen.next = eleven;

        eleven.random = one;
        eleven.next = ten;

        ten.random = eleven;
        ten.next = one;

        one.random = seven;

        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
        Node result = copyListWithRandomPointer.copyRandomList(seven);

        assertThat(result.next.random.val, is(seven.val));

    }
    
    static Node c(int v) {
        return new Node(v);
    }
}
