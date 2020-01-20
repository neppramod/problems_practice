import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {1};

        int result = climbStairs(50);

        System.out.println(result);

    }

    public static int climbStairs(int n) {
        int[] dp = new int[n+1];

        //  dp[i] = number of distinct way to climb stairs i
        // stairs i can only be reached from i-1 and i-2, so only 2 ways
        // base case dp[0] = 1, only 1 way to climb no stairs, i.e 0
        dp[0] = 1;
        int K = 2;  // number of steps

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= K; k++) {
                if (i >= k) {
                    dp[i] += dp[i-k];
                }
            }
        }

        return dp[n];
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
