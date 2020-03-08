import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text1 = "adfasdfasdfasdfasdfadf", text2 = "3asdfasd342423432fda";
        int lcs = lcs(text1.toCharArray(), text2.toCharArray());
        System.out.println(lcs);
    }

    static int lcs(char[] s, char[] t) {
        int M = s.length;
        int N = t.length;

        int[][] dp = new int[M+1][N+1];

        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s[i-1] == t[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[M][N];
    }
}
