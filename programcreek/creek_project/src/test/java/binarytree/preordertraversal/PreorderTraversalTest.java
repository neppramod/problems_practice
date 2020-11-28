package binarytree.preordertraversal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import binarytree.TreeNode;
import static binarytree.TreeNode.c;

import java.util.List;

public class PreorderTraversalTest {

    @Test
    public void testPreOrderTraversal() {
        TreeNode r = c(1);
        r.right = c(2);
        r.right.left = c(3);

        PreorderTraversal preorderTraversal = new PreorderTraversal();
        List<Integer> result = preorderTraversal.preOrederTraversal(r);

        assertThat(result.get(0), is(1));
        assertThat(result.get(1), is(2));
        assertThat(result.get(2), is(3));
    }


}