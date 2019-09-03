import java.util.*;

public class Frog2
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] h = new int[N];
        for (int i = 0; i < N; i++) {
            h[i] = sc.nextInt();
        }

        System.out.println(minimumTotalCost(h, K));
    }

    private static int minimumTotalCost(int[] h, int K)
    {
        int N = h.length;
        int[] dp = new int[N];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j <= i+K; j++) {
                if (j < N) {
                    dp[j] = Math.min(dp[j], dp[i] + Math.abs(h[j] - h[i]));
                }
            }
        }

        return dp[N-1];
    }
}
