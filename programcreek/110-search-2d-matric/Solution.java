import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[][] matrix = {{1, 3, 5, 7},
						  {10, 11, 16, 20},
				{ 23, 30, 34, 50 } };

		boolean result = sol.find(matrix, 3);
		System.out.println(result);
    }
    
    /* Search a 2D matrix */
	boolean find(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int end = m * n - 1;
		int start = 0;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			int midX = mid / n;
			int midY = mid % n;

			if (target == matrix[midX][midY]) {
				return true;
			}

			if (target < matrix[midX][midY]) {
				end = mid -1;
			} else if (target > matrix[midX][midY]) {
				start = mid + 1;
			} 
		}

		return false;
		
	}
}
