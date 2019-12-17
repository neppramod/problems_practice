import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] graph = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;  // directed, without cycle
        }

        System.out.println(longest(graph, N));
    }

    static long longest(int[][] graph, int N)
    {
        long[] dp = new long[N+1];


        long result = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (dp[i] + 1 > dp[j] && graph[i][j] != 0) {
                    dp[j] = dp[i] + 1;
                    result = Math.max(result, dp[j]);
                }
            }
        }

        return result + 1;
    }
}
