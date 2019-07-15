import java.util.*;

public class LCS
{
    static int lcs(char[] s1, char[] s2, int i, int j)
    {

        if (i >= s1.length || j >= s2.length) return 0;
        if (s1[i] == s2[j]) {
            return 1 + lcs(s1, s2, i+1, j+1);
        } else return Math.max(lcs(s1, s2, i+1, j), lcs(s1, s2, i, j+1));
    }

    public static void main(String[] args)
    {
        char[] s1 = "AGGTAB".toCharArray();
        char[] s2 = "GXTXAYB".toCharArray();

        System.out.println("LCS: " + lcs(s1, s2, 0, 0));
        System.out.println("LCS: " + lcsdp(s1, s2));
    }

    static int lcsdp(char[] s1, char[] s2)
    {
        int M = s1.length;
        int N = s2.length;
        int dp[][] = new int[M+1][N+1];
        char[][] lcschars = new char[M+1][N+1];
        for (int i = 0; i <= M; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= N; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (s1[i-1] == s2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    lcschars[i][j] = '\\';
                } else if (dp[i-1][j] > dp[i][j-1]){
                    dp[i][j] = dp[i-1][j];
                    lcschars[i][j] = '^';
                } else {
                    dp[i][j] = dp[i][j-1];
                    lcschars[i][j] = '<';
                }
            }
        }

        printlcs(lcschars, s1, M, N);
        System.out.println();

        return dp[M][N];
    }

    static void printlcs(char[][] lcschars, char[] s1, int i, int j)
    {
        if (i <= 0 || j <= 0) return;
        if (lcschars[i][j] == '\\') {
            printlcs(lcschars, s1, i-1, j-1);
            System.out.print(s1[i-1]);
        } else if (lcschars[i][j] == '^') {
            printlcs(lcschars, s1, i-1, j);
        } else {
            printlcs(lcschars, s1, i, j-1);
        }
    }
}
