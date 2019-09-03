import java.util.*;

public class LCS {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        lcs(s1, s2);
    }

    private static void lcs(String s1, String s2) {
        int M = s1.length();
        int N = s2.length();

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();

        int[][] dp = new int[M + 1][N + 1];
        char[][] dir = new char[M + 1][N + 1];

        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (X[i - 1] == Y[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    dir[i][j] = '\\';
                } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    dir[i][j] = '|';
                } else {
                    dp[i][j] = dp[i][j - 1];
                    dir[i][j] = ' ';
                }
            }
        }

        printlcs(dir, X, M, N);
        System.out.println();
    }

    private static void printlcs(char[][] dir, char[] X, int i, int j) {
        if (i < 0 || j < 0)
            return;
        if (dir[i][j] == '\\') {
            printlcs(dir, X, i - 1, j - 1);
            System.out.print(X[i - 1]);
        } else if (dir[i][j] == '|') {
            printlcs(dir, X, i - 1, j);
        } else {
            printlcs(dir, X, i, j - 1);
        }
    }
}
