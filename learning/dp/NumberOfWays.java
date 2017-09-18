import java.util.*;

public class NumberOfWays
{

    public static int numberOfWays(int i, int[] memo)
    {
        if (memo[i] != -1) return memo[i];

        if (i == 1) return 1;
        if (i == 2) return 2;

        memo[i] = numberOfWays(i-1, memo) + numberOfWays(i-2, memo);
        return memo[i];
    }

    public static int numberOfWays(int N)
    {
        int[] memo = new int[N+1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= N; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[N];
    }

    public static int numberOfWaysSlow(int N)
    {
        if (N == 1) return 1;
        if (N == 2) return 2;
        return numberOfWaysSlow(N - 1) + numberOfWaysSlow(N - 2);
    }

    public static void main(String[] args)
    {
        int N = 10;
        int[] memo = new int[N+1];
        Arrays.fill(memo, -1);
        System.out.println(numberOfWays(N, memo));
        System.out.println(numberOfWays(N));
        System.out.println(numberOfWaysSlow(N));
    }
}
