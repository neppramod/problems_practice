package binarytree.longestconsecutivesequence;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import binarytree.TreeNode;
import static binarytree.TreeNode.c;

public class LongestConsecutiveSequenceTest {

	@Test
	public void testLongestConsecutive() {
		TreeNode r = c(1);
		r.right = c(3);
		r.right.left = c(2);
		r.right.right = c(4);
		r.right.right.right = c(5);

		LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();

		int result = longestConsecutiveSequence.longestConsecutive(r);
		assertThat(result, is(3));
	}
}
