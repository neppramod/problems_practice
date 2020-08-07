import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {2, 7, 4, 1, 8, 1};

        int result = solve(arr);

        System.out.println(result);

    }

    static int solve(int[] arr) {
        // 0-1 knapsack.
        // ans = sum - 2 * target
        int sum = sum(arr);
        int W = sum/2;

        int[] dp = new int[W+1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = W; j >= arr[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-arr[i]] + arr[i]);
            }
        }

        //pA1(dp);
        // pI1("W", W);
        //pI1("sum", sum);

        return sum - 2 * dp[W];
    }

    static int sum(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }

        return result;
    }

    static void pI1(String var, int val) {
        System.out.printf("%s: %d\n", var, val);
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
