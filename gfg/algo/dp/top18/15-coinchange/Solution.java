import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = {1, 2, 3};
        int m = arr.length;
        System.out.println( count(arr, m, 4));
        System.out.println( countDP(arr, m, 4));

    }

    static int count(int[] arr, int m, int n)
    {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (m <= 0 && n >= 1) return 0;
        return count(arr, m, n-arr[m-1]) + count(arr, m-1, n);
    }

    static int countDP(int[] arr, int m, int n)
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = arr[i]; j <= n; j++) {
                dp[j] += dp[j-arr[i]];
            }
        }

        return dp[n];
    }
}
