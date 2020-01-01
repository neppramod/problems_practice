import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 5, 3};
        System.out.println(findSubsetSumDP(arr, arr.length));

    }

    static boolean findSubsetSumDP(int[] arr, int n)
    {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return false;
        }


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

        return dp[sum/2][n];
    }
}
