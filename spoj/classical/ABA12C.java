import java.util.*;

public class ABA12C
{
    static final int INF = 1000000000;

    static int minCost(int N, int K, int[] prices)
    {
        int[][] result = new int[N+1][K+1];
        Arrays.fill(result[0], INF);
        result[0][0] = 0;
        // result[i][0] = 0; implied

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                int minres = INF;

                for (int k = 1; k <= j; k++) {
                    if (prices[k-1] != -1) {
                        int tres = result[i-1][j-k] + prices[k-1];
                        if (tres < minres)
                            minres = tres;
                    }
                }

                result[i][j] = minres;
            }
        }

        return result[N][K];
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] prices = new int[K];

            for (int k = 0; k < K; k++) {
                prices[k] = sc.nextInt();
            }

            int result = minCost(N, K, prices);
            System.out.println(result == INF ? "-1" : result);
        }
    }
}
