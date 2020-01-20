import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] arr = {
            "001010".toCharArray(),
            "011001".toCharArray(),
            "111110".toCharArray(),
            "011111".toCharArray(),
            "011111".toCharArray(),
            "111110".toCharArray(),
            "000000".toCharArray(),
        };

        //char[][] arr = new char[1][0];

        int result = solve(arr);

        System.out.println(result);

    }

    /*
      Solve in paper first, for a bigger square, with more ones

      in dp, fill all cells with values from matrix.
      If current cell is 0, don't do anything.
      Else.
      If any of the 4 elements in the square as current cell as right most edge is 0, don't increment current cell.
      Else, get minimum of all other 3 cells, if 1, add 1 and square the value to replace current cell.

      E.g. If more than 1, root square the values from other cells, add 1 and square to replace current cell.
      You can save max so far, or scan all cells later to find it.
    */

    static int solve(char[][] matrix) {

        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                result = Math.max(result, dp[i][j]);
            }
        }

        //int result = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] == 1) {
                    int min = Math.min(dp[i-1][j], dp[i][j-1]);
                    min = Math.min(min, dp[i-1][j-1]);
                    if (min == 1) {
                        dp[i][j] = 4;
                    } else if (min > 1) {
                        int root = (int)Math.sqrt(min);
                        // increment one to prev root and square
                        root = root + 1;
                        dp[i][j] = root * root;
                    }

                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        // pA2(dp);
        return result;
    }

    static void pA1(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
