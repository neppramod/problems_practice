import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] X = sc.next().toCharArray();
        char[] Y = sc.next().toCharArray();

        lcs(X, Y);
    }

    static void lcs(char[] X, char[] Y)
    {
        int M = X.length;
        int N = Y.length;

        long[][] dp = new long[M+1][N+1];
        char[][] C = new char[M+1][N+1];

        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X[i-1] == Y[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    C[i][j] = '\\';
                } else if (dp[i-1][j] >= dp[i][j-1]) {
                    dp[i][j] = dp[i-1][j];
                    C[i][j] = '|';
                } else {
                    dp[i][j] = dp[i][j-1];
                    C[i][j] = '-';
                }
            }
        }


        LinkedList<Character> linkedList = new LinkedList<>();
        int i = M, j = N;

        while(i > 0 && j > 0) {
            if (X[i-1] == Y[j-1]) {
                linkedList.addFirst(X[i-1]);
                i--;
                j--;
            } else if (C[i][j] == '|') {
                i--;
            } else {
                j--;
            }

        }

        StringBuilder sb = new StringBuilder();
        for (char c : linkedList) {
            sb.append(c);
        }

        System.out.println(sb.toString());

    }
}
