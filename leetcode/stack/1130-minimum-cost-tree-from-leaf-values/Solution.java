import java.util.*;


/*

  s => (()()(((()

 */

public class Solution
{
    static int MAX = 500000;
    public static void main(String[] args) {
        int[] arr = {6, 2, 4};

        int result = minAddToMakeValid(arr);
        System.out.println(result);
    }

    public static int minAddToMakeValid(int[] arr) {
        int[][] dp = new int[5][5];

        for (int i = 0; i < 5; i++) {
            Arrays.fill(dp[i], MAX);
        }

        for (int i = 0; i < 5; i++) {
            dp[i][i] = 0;
        }

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = i; k < j; k++) {
                    int a1 = getMax(arr, i, k);
                    int a2 = getMax(arr, k+1, j);
                    dp[i][j] = Math.min(dp[i][j], a1 * a2 + dp[i][k] * dp[k+1][j]);
                }
            }
        }

        pA2(dp);

        return dp[0][n-1];
    }

    static void pA1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%7d", arr[i]);
        }
        System.out.println();
    }

    static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pA1(arr[i]);
        }
    }

    static int getMax(int[] arr, int i, int j) {
        int max = arr[i];
        for (int k = i+1; k <= j; k++) {
            max = Math.max(max, arr[k]);
        }

        return max;
    }
}
