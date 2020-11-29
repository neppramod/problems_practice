package binarytree.kthsmallestelementinabst;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import binarytree.TreeNode;

import static binarytree.TreeNode.c;

public class KthSmalletElementInABSTTest {

	@Test
	public void testKthSmallest() {
		KthSmalletElementInABST kthSmalletElementInABST = new KthSmalletElementInABST();
		TreeNode r = c(5);
		r.left = c(2);
		r.left.right = c(4);

		r.right = c(8);
		r.right.left = c(6);
		r.right.right = c(12);

		int result = kthSmalletElementInABST.kthSmallest(r, 5);
		assertThat(result, is(8));
	}
}
