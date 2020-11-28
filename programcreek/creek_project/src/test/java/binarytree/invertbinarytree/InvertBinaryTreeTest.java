package binarytree.invertbinarytree;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import static binarytree.TreeNode.c;
import binarytree.TreeNode;

import org.junit.Test;

public class InvertBinaryTreeTest {
    @Test
    public void testInvertBinaryTree() {
        TreeNode r = c(3);
        r.left = c(9);
        r.right = c(20);
        r.right.left = c(15);
        r.right.right = c(7);

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode res = invertBinaryTree.invertTree(r);

        assertThat(res.val, is(3));
        assertThat(res.left.val, is(20));
        assertThat(res.right.val, is(9));
        assertThat(res.left.left.val, is(7));
        assertThat(res.left.right.val, is(15));
    }
}