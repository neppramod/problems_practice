import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();

        System.out.println(lcs(c1, c2, c1.length, c2.length));
        System.out.println(lcsdp(c1, c2, c1.length, c2.length));
    }

    static int lcs(char[] X1, char[] X2, int m, int n)
    {
        if (m == 0 || n == 0) return 0;
        if (X1[m-1] == X2[n-1]) return 1 + lcs(X1, X2, m-1, n-1);
        else return Math.max(lcs(X1, X2, m, n-1), lcs(X1, X2, m-1, n));
    }

    static int lcsdp(char[] X1, char[] X2, int m, int n)
    {
        int dp[][] = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (X1[i-1] == X2[j-1]) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m][n];
    }
}
