import java.util.*;

/*
  Subset Sum Problem | DP-25
  Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 
  Example: {3,34,4,12,5,2}, sum = 9
 */

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int arr[] = {3,34,4,12,5,2};
        int n = arr.length;
        int sum = 13;

        System.out.println(isSubSetSum(arr,sum, n));
        System.out.println(isSubSetSumDP(arr,sum, n));
    }

    static boolean isSubSetSum(int[] arr, int sum, int n)
    {
        if (sum == 0) return true;
        if (n == 0 && sum != 0) return false;

        return isSubSetSum(arr, sum-arr[n-1], n-1) || isSubSetSum(arr, sum, n-1);
    }

    static boolean isSubSetSumDP(int[] arr, int sum, int n)
    {
        boolean dp[][] = new boolean[sum+1][n+1];

        // since 0 sum can be created from any element
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
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

        return dp[sum][n];
    }
}
