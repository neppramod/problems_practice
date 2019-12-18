import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double[] p = new double[N];

        for (int i = 0; i < N; i++) {
            p[i] = sc.nextDouble();
        }

        double[][] dp = new double[N+1][N+1];
        boolean[][] visited = new boolean[N+1][N+1];

        double total = 0;
        for (int i = N/2 + 1; i <= N; i++) {
            total += solve(p, i, N, dp, visited);
        }

        System.out.println(total);
    }

    static double solve(double[] p, int i, int N, double[][] dp, boolean[][] visited) {
        if (i < 0) {
            return 0;
        } else if (N == 0) {
            return i == 0 ? 1 : 0;
        } else if (visited[N][i]) {
            return dp[N][i];
        } else {
            visited[N][i] = true;
            return dp[N][i] = p[N-1] * solve(p, i-1, N-1, dp, visited) + (1 - p[N-1]) * solve(p, i, N-1, dp, visited);
        }
    }
}
