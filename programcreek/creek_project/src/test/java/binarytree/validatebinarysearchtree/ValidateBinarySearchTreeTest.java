package binarytree.validatebinarysearchtree;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import binarytree.TreeNode;

import static binarytree.TreeNode.c;

public class ValidateBinarySearchTreeTest {

	@Test
	public void testValidBST() {
		TreeNode r = c(4);
		r.left = c(2);
		r.left.left = c(1);
		r.left.right = c(3);

		r.right = c(7);
		r.right.left = c(6);
		r.right.right = c(9);

		ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
		assertThat(validateBinarySearchTree.isValidBST(r), is(true));
	}
}
