import java.util.*;

public class Partition
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {3,5,6,7,59};
        System.out.println(getPartition(arr,arr.length));
        System.out.println(getPartitionDP(arr,arr.length));
    }

    static boolean getPartition(int[] arr, int n)
    {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) return false;
        return findPartition(arr, sum/2, n);
    }

    static boolean getPartitionDP(int[] arr, int n)
    {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) return false;
        return findPartitionDP(arr, sum/2, n);
    }


    static boolean findPartition(int[] arr, int sum, int n)
    {
        if (sum == 0) return true;
        if (n == 0 && sum != 0) return false;

        return findPartition(arr, sum, n-1) | findPartition(arr, sum-arr[n-1], n-1);
    }

    static boolean findPartitionDP(int[] arr, int sum, int n)
    {

        boolean dp[][] = new boolean[sum+1][n+1];

        // initialize first row to true, first column to false
        // sum 0 can be achieved without using any item
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
