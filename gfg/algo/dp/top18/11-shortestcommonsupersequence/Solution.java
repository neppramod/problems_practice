import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(scs(s1.toCharArray(),s2.toCharArray()));

    }

    static int scs(char[] c1, char[] c2)
    {
        return c1.length + c2.length - lcs(c1,c2);
    }

    static int lcs(char[] c1, char[] c2)
    {
        int m = c1.length;
        int n = c2.length;

        int dp[][] = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i-1] == c2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {

                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
