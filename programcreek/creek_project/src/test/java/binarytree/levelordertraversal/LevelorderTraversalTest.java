package binarytree.levelordertraversal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import binarytree.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LevelorderTraversalTest {

    @Test
    public void levelOrder() {
        TreeNode r = c(3);
        r.left = c(9);
        r.right = c(20);
        r.right.left = c(15);
        r.right.right = c(7);

        LevelorderTraversal levelorderTraversal = new LevelorderTraversal();
        List<List<Integer>> result = levelorderTraversal.levelOrder(r);

        assertThat(result.get(0), is(Arrays.asList(3)));
        assertThat(result.get(1), is(Arrays.asList(9, 20)));
        assertThat(result.get(2), is(Arrays.asList(15, 7)));

    }

    @Test
    public void testReverse() {
        TreeNode r = c(3);
        r.left = c(9);
        r.right = c(20);
        r.right.left = c(15);
        r.right.right = c(7);

        LevelorderTraversal levelorderTraversal = new LevelorderTraversal();
        List<List<Integer>> result = levelorderTraversal.levelOrder(r);
        Collections.reverse(result);

        assertThat(result.get(0), is(Arrays.asList(15, 7)));

    }


    static TreeNode c(int v) {
        return new TreeNode(v);
    }
}