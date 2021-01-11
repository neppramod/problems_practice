/**
   Binary indexed tree or Fenwick tree is a dynamic variant of prefix sum array. 
Binary indexed tree supports two O(longn) time operations on an array:
  - processing a range sum query
  - updating a value

tree[k] = query(k - p(k) + 1, k);

k is 1 based.
p(k) = k & (-k);

E.g. If k = 6, p(k) = 6 & (-6) or 6 & (2) = 2.
Here -6 is represented as 2s compliment number, therefore 6 = 110, -6 = 11111001 + 1 = 11111010
110 & 010 = 010

E.g a = {1, 3, 4, 8, 6, 1, 4, 2};
Corresponding binary indexed tree = 

|0|1|2|3|4 |5|6|7|8 |
|0|1|4|4|16|6|7|4|29|

Using a binary indexed tree, any value query(1, k) can be calculated in O(logn) time, because
a range [1, k] can always be divided into O(logn) ranges

E.g query(1, 7) = query(1, 4) + query(5, 6) + query(7, 7) = 16 + 7 + 4 = 27

To calculate the value of query(a, b), where a > 1
query(a, b) = query(1, b) - query(1, a - 1);

a, b is 1 based index. So arr[0] element is 1 in the query index.

Since we can calculate any range using range from 1 to that index, below we only call query with end index and calculate the range from 1 to that number.

When creating a fenwick tree, we set enough storage to fit the array in 2 power index.

 */

static class Fenwick
{
	int[] tree;

	public Fenwick(int n) {
		tree = new int[n+1];
	}

	public void add(int i, int val) {
		while (i < tree.length) {
			tree[i] += val;
			i += (i & -i);
		}
	}		

	public int query(int i) {
		int sum = 0;
		while (i > 0) {
			sum += tree[i];
			i -= (i & -i);
		}

		return sum;
	}
}
