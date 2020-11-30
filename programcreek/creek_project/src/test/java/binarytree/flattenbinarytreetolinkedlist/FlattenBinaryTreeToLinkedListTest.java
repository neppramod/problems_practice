package binarytree.flattenbinarytreetolinkedlist;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import binarytree.TreeNode;

import static binarytree.TreeNode.c;

public class FlattenBinaryTreeToLinkedListTest {

	@Test
	public void testFlattenBinaryTree() {
		TreeNode r = c(1);
		r.left = c(2);
		r.right = c(5);
		r.left.left = c(3);
		r.left.right = c(4);

		r.right.right = c(6);

		FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();

		flattenBinaryTreeToLinkedList.flatten(r);
		assertThat(r.val, is(1));
		assertThat(r.right.val, is(2));
		assertThat(r.right.right.val, is(3));
		assertThat(r.right.right.right.val, is(4));
		assertThat(r.right.right.right.right.val, is(5));
		assertThat(r.right.right.right.right.right.val, is(6));
	}

	@Test
	public void testFlattenSingleNode() {
		TreeNode r = c(1);
		
		FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();

		flattenBinaryTreeToLinkedList.flatten(r);
		assertThat(r.val, is(1));
	}
}
