import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {10, 20, 15, 5, 25};
        System.out.println(isSameSubset(arr));

    }

    static int isSameSubset(int[] arr)
    {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return findSubsetSumDP(arr, sum, arr.length);
    }



    static int findSubsetSumDP(int[] arr, int sum, int n)
    {
        boolean[][] dp = new boolean[sum+1][n+1];

        // first row is true, because you can construct a sum of 0, without including any elements
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }

        // first column is false, because you cannot construct a sum greater than 0, without any elements
        for (int i = 1; i <= sum; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1];
                if (i >= arr[j-1]) {
                    dp[i][j] |= dp[i-arr[j-1]][j-1];
                }
            }
        }

        int diff = Integer.MAX_VALUE;

        for (int j = sum/2; j >= 0; j--) {
            if (dp[j][n] == true) {
                diff = sum - 2 * j;
                break;
            }
        }

        return diff;
    }
}
