package binarytree.inordertraversal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import binarytree.TreeNode;
import org.junit.Test;

import java.util.List;

import static binarytree.TreeNode.c;


public class InorderTraversalTest {
    @Test
    public void testInorderTraversal() {
        TreeNode r = c(1);
        r.right = c(2);
        r.right.left = c(3);

        List<Integer> result = new InorderTraversal().inorderTraversal(r);
        assertThat(result.get(0), is(1));
        assertThat(result.get(1), is(3));
        assertThat(result.get(2), is(2));
    }
}