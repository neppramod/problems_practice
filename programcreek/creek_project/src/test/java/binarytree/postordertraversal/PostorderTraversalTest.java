package binarytree.postordertraversal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import binarytree.TreeNode;
import org.junit.Test;


import java.util.List;

import static binarytree.TreeNode.c;


public class PostorderTraversalTest {

    @Test
    public void postorderTraversal() {
        TreeNode r = c(1);
        r.right = c(2);
        r.right.left = c(3);

        List<Integer> result = new PostorderTraversal().postorderTraversal(r);

        assertThat(result.get(0), is(3));
        assertThat(result.get(1), is(2));
        assertThat(result.get(2), is(1));


    }
}