import java.util.*;

public class Solution
{
    private static final int MAXN = 400;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] plates = new int[4];
        for (int i = 0; i < N; i++) {
            int cur = sc.nextInt();
            plates[cur]++;   // save counts of 1, 2 or 3 sushi plates
        }

        boolean[][][] visited = new boolean[MAXN][MAXN][MAXN];
        double[][][] dp = new double[MAXN][MAXN][MAXN];

        System.out.println(expectedAttempts(plates[1], plates[2], plates[3], visited, dp, N));
    }

    static double expectedAttempts(int a, int b, int c, boolean[][][] visited, double[][][] dp, int N) {

        // here a, b, c never goes below 0
        if (visited[a][b][c]) {
            return dp[a][b][c];
        } else if (a == 0 && b == 0 && c == 0) {
            visited[a][b][c] = true;
            return dp[a][b][c] = 0;
        } else {
            visited[a][b][c] = true;
            double k = a + b + c;

            double sum = N/k;
            sum += a == 0 ? 0 : (a/k) * expectedAttempts(a-1, b, c, visited, dp, N);
            sum += b == 0 ? 0 : (b/k) * expectedAttempts(a+1, b-1, c, visited, dp, N);
            sum += c == 0 ? 0 : (c/k) * expectedAttempts(a, b+1, c-1, visited, dp, N);

            return dp[a][b][c] = sum;
        }
    }

}
