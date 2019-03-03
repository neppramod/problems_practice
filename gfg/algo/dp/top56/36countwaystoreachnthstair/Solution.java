import java.util.*;

public class Solution
{
    static int c1 = 0;
    static int c2 = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(countWays(N));

        int[] dp = new int[N+1];
        Arrays.fill(dp, -1);

        System.out.println(countWaysDP(N, dp));
        System.out.printf("C1: %d, C2: %d\n", c1, c2);

        System.out.println(countWaysDPTable(N));

    }

    static int countWays(int N)
    {
        if (N == 0) return 1;
        if (N == 1) return 1;
        c1++;
        return countWays(N-1) + countWays(N-2);

    }

    static int countWaysDP(int N, int[] dp)
    {
        if (dp[N] != -1) return dp[N];
        dp[0] = 1;
        dp[1] = 1;

        c2++;
        dp[N] = countWaysDP(N-1, dp) + countWaysDP(N-2, dp);
        return dp[N];
    }

    static int countWaysDPTable(int N)
    {
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N];

    }
}
