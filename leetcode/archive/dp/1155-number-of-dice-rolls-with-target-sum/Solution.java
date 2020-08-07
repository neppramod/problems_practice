import java.util.*;

public class Solution
{

    static final int MOD = 1000000007;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int d = 30, f = 30, target = 500;
        int result = solve(d, f, target);

        System.out.println(result);

    }

    static int solve(int d, int f, int target) {
        int[][] dp = new int[d+1][target+1];
        dp[0][0] = 1;
        for (int i = 1; i <= d; i++) {
            for (int j = i; j <= target; j++) {

                dp[i][j] = (dp[i][j-1] + dp[i-1][j-1]) % MOD;

                if (j-f > 0) {
                    dp[i][j] = (dp[i][j] - dp[i-1][j-f-1])%MOD;
                }
            }
        }

        return dp[d][target] < 0 ? dp[d][target] + MOD : dp[d][target];
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
