import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //int arr[] = {3, 1, 5, 9, 12};
        int arr[] = {3,1,5,9,14};
        int n = arr.length;

        System.out.println(findPartition(arr,n));
    }

    static boolean findPartition(int[] arr, int n)
    {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) return false;
        return isSubSetSum(arr, sum/2, n);
        //return isSubSetSumDP(arr, sum/2, n);
    }

    static boolean isSubSetSum(int[] arr, int sum, int n)
    {
        if (sum == 0) return true;
        if (n == 0 && sum != 0) return false;

        return isSubSetSum(arr, sum-arr[n-1], n-1) | isSubSetSum(arr, sum, n-1);
    }

    static boolean isSubSetSumDP(int[] arr, int sum, int n)
    {
        boolean dp[] = new boolean[n+1];
        dp[0] = true;
        dp[1] = false;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1];
            for (int j = 0; j < arr.length; j++) {
                if (i>=arr[j]) {
                    dp[i] |= dp[i-arr[j]];
                }
            }
        }

        return dp[n];
    }
}
