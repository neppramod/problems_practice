import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] h = new int[N];


        for (int i = 0; i < N; i++) {
            h[i] = sc.nextInt();
        }

        long[] dp = new long[N];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int k = 1; k <= K; k++) {
                if(i-k >= 0) {
                    dp[i] = Math.min(dp[i], dp[i-k] + Math.abs(h[i] - h[i-k]));
                }
            }
        }

        System.out.println(dp[N-1]);
    }
}
