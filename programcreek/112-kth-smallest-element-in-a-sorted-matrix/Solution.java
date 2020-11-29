import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };

		int result = sol.kthSmallest(matrix, 8);
		System.out.println(result);
	}

	int kthSmallest(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return -1;
		}

		int total = matrix.length * matrix[0].length;
		int l = 0, r = total - 1;
		int cols = matrix[0].length;
		int rows = matrix.length;

		while (l <= r) {
			int m = l + (r - l) / 2;

			if (m + 1 == k) {
				return matrix[m / cols][m % rows];
			} else if (m + 1 < k) {
				l = m + 1;
			} else {
				r = m;
			}
		}

		return -1;
	}
}

/*

matrix = 
[[1, 5, 9],
[10, 11, 13],
[12, 13, 15]];

lower = 1, upper = 15;

1 <= 15
mid = 1 + (15-1) / 2 = 1 + 7 = 8
count = count(matrix, 8) = 2

count < 8, lower = 9, upper = 15

9 <= 15
mid = 9 + (15-9) / 2 = 9 + 3 = 12

count = count(matrix, 12)

i = 2, j = 0, count = 0

while (2 >= 0 && 0 < 3)
   matrix[2][0] <= 12, count = (3), j = 1

   matrix[2][1] <= 12 X, i = 1
   10 <= 12, count = +2 = 5, j = 2, i = 0
   
matrix[0][1] <= count += 5 + 1 = 6, j = 3, count = 6,

6 < 8, lower = 13, upper = 15
mid = 13 + 1 = 14
count = count(matrix, 14)


i = 2, j = 0, count = 0;

while (i >= 0 && 0 < 3) {

if (matrix[2][0] <= 14) {
count = 3, j = 1
}
}

matrix[2][1] <= 14
count = 6
j = 2

15 <= 14 X, i = 1

13 <= 14, count = 6 + 2 = 8, j = 3 => 8

count = 8, 8 < 8 X, upper = 14, mid = 13 + 0 = 13, count(matrix, 13) = 8, upper = 13

return 13


 */
