import java.util.*;

public class Solution
{
    private static final long MOD = 1000000007L;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        char[] s = new char[N+1];
        String str = sc.next();

        for (int i = 0; i < str.length(); i++) {
            s[i+1] = str.charAt(i);
        }

        long[][] dp = new long[N+1][N+1];
        long[][] prefix = new long[N+1][N+1];
        System.out.println(solve(dp, prefix, N, s));


    }

    static long solve(long[][] dp, long[][] prefix, int n, char[] s)
    {
        dp[1][1] = prefix[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (s[i-1] == '<') {
                    dp[i][j] = prefix[i-1][j-1];   // 0 to i-1,j-1
                } else {
                    dp[i][j] = (prefix[i-1][i-1] - prefix[i-1][j-1]) % MOD;  // only part
                }
            }

            for (int j = 1; j <= i; j++) {
                prefix[i][j] = (prefix[i][j-1] + dp[i][j]) % MOD;
            }
        }

        return (prefix[n][n] + MOD) % MOD;
    }

}
