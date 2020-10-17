import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[][] matrix = {{1, 4, 7, 11, 15},
						  {2, 5, 8, 12, 9},
						  {3, 6, 9, 16, 22},
						  {10, 13, 14, 17, 24},
				{ 18, 21, 23, 26, 30 } };
		boolean result = sol.searchMatrix(matrix, 5);
		System.out.println(result);
    }
    
    boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		// here each row is sorted and each column is sorted, but first number of each row can be smaller than last number of previous row
		// we need to narrow search starting from last row first column towards first row last column until we find the target

		int m = matrix.length;
		int n = matrix[0].length;

		int i = m - 1;
		int j = 0;

		while (j <= n-1 && i >= 0) {
			if (target < matrix[i][j]) {
				i--;  // go up
			} else if (target > matrix[i][j]) {
				j++; // go right
			} else {
				return true;
			}
		}

		return false;
	}
}
