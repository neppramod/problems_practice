import java.util.*;

/*
  Segment Tree: A segment tree is a binary tree, such that the nodes
  on the bottom level of the tree correspond to the array element, and the other
  nodes contain information needed for processing range queries.

  Here we use 1 based indexing.
  E.g arr = {5, 8, 6, 3, 2, 7, 2, 6}

  here n = 8

  for i = 0 to 7:
    add(0, 5): idash = 8, tree[8] = 5, , tree]9] = 8, tree[4] = tree[8] + tree[9] = 13

   |0|39|22|17|13|9|9|8|5|8|6|3|2|6|2|6|

   query(2, 7) = arr[2] + arr[3] + arr[4] + arr[5] + arr[6] + arr[7] = 6 + 3 + 2 + 7 + 2 + 6 = 26

   
*/

class SegmentTree {
	int[] tree;
	int n;

	public SegmentTree(int n) {
		tree = new int[2 * n];
		this.n = n;
	}

	// add val at index i
	public void add(int i, int val) {
		i += n;
		tree[i] += val;

		for (i /= 2; i > 0; i /= 2) {
			tree[i] = tree[2 * i] + tree[2 * i + 1];
		}
	}

	// query elements from index i to j-1
	public int query(int i, int j) {
		i += n;
		j += n;
		int sum = 0;

		while (i < j) {
			if (i % 2 == 1)
				sum += tree[i++];
			if (j % 2 == 1)
				sum += tree[--j];

			i /= 2;
			j /= 2;
		}

		return sum;

	}

	public static void main(String[] args) {
		int n = 8;
		SegmentTree s = new SegmentTree(n);
		int[] arr = { 5, 8, 6, 3, 2, 7, 2, 6 };

		for (int i = 0; i < n; i++) {
			s.add(i, arr[i]);
		}

		System.out.println(Arrays.toString(s.tree));
		System.out.println(s.query(2, 8));  // range from index 2 to index 7 = 6 + 3 + 2 + 7 + 2 + 6 = 26
	}
}
