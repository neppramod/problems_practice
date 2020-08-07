import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {2,1, 1, 2};
        int rob = rob(arr);
        System.out.println(rob);
    }

    public static int rob(int[] arr) {
        int n = arr.length;

        if (n == 2) {
            return Math.max(arr[0], arr[1]);
        } else if (n == 1) {
            return arr[0];
        } else if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
        }

        return dp[n-1];
    }
}
