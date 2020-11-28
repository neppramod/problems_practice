package binarytree.verticalordertraversal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import binarytree.TreeNode;

import java.util.Arrays;
import java.util.List;

import static binarytree.TreeNode.c;

public class VerticalorderTraversalTest {
    @Test
    public void testVerticalOrder() {
        TreeNode r = c(3);
        r.left = c(9);
        r.right = c(20);
        r.right.left = c(15);
        r.right.right = c(7);

        VerticalorderTraversal verticalorderTraversal = new VerticalorderTraversal();
        List<List<Integer>> list = verticalorderTraversal.verticalOrder(r);

        assertThat(list.get(0), is(Arrays.asList(9)));
        assertThat(list.get(1), is(Arrays.asList(3, 15)));
        assertThat(list.get(2), is(Arrays.asList(20)));
        assertThat(list.get(3), is(Arrays.asList(7)));

    }
}