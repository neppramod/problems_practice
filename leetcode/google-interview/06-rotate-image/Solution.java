import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
		int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		Solution sol = new Solution();
		sol.rotate(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
    }
    
	void rotate(int[][] matrix) {
		int n = matrix.length;

		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < Math.ceil(n/2.0); j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = tmp;
			}
		}
	}
}
