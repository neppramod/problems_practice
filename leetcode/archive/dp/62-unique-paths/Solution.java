import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {1};
        int m = 3;
        int n = 2;

        int result = solve(m, n);

        System.out.println(result);

    }

    /*
    static int solve(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        } else if (m == 1 && n == 1) {
            return 1;
        } else {
            return solve(m-1, n) + solve(m, n-1);
        }
    }
    */

    static int solve(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }

        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] += dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m][n];

    }

    static void pA1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println();
    }

    static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pA1(arr[i]);
        }
    }
}
