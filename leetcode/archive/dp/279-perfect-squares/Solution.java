import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {};
        int n = 12;

        int result = solve(n);

        System.out.println(result);

    }

    static int solve(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = 0; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

        return dp[n];
    }

    static boolean isPerfectSquare(int n) {
        int a = (int)Math.sqrt(n);
        return (a * a == n);
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
