import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {{1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}};

        boolean result = sol.searchMatrix(matrix, 34);
        System.out.println(result);
        result = sol.searchMatrix1(matrix, 34);
        System.out.println(result);
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
           return false;
       }

       int m = matrix.length;
       int n = matrix[0].length;

       int i = 0;
       int j = m * n - 1;

       while (i <= j) {
           int mid = (i + j)/2;

           int x = mid / n;
           int y = mid % n;

           if (matrix[x][y] == target) {
               return true;
           } else if (matrix[x][y] > target) {
               j = mid - 1;
           } else {
               i = mid + 1;
           }
       }

       return false;
    }
}
