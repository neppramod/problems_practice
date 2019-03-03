import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(nWays(4));
        System.out.println(nWaysDP(4));
    }

    static int nWays(int N)
    {
        if (N == 0) return 1;
        if (N == 1) return 1;

        return nWays(N-1) + nWays(N-2);
    }

    static int nWaysDP(int N)
    {
        int dp[] = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N];
    }
}
