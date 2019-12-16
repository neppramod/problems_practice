import java.util.*;

public class SolutionBrute
{
    static final long MOD = (long) Math.pow(10, 9) + 7;
    static final int MAXN = (int) Math.pow(10, 5) + 1;

    public static void main(String[] args)
    {


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] h = new int[N];
        long[] a = new long[N];

        for (int i = 0; i < N; i++) {
            h[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextLong();
        }

        long solution = solve(a, h, N);

        System.out.println(solution);
    }

    static long solve(long[] a, int[] h, int N)
    {
        long[] dp = new long[N+1];   // since no height bigger than N
        // dp[i] = maximum total beauty so far if the last taken flower has height i
        for (int flower = 0; flower < N; flower++) {
            for (int i = 0; i < h[flower]; i++) {
                dp[h[flower]] = Math.max(dp[h[flower]], dp[i] + a[flower]);
            }
        }

        long answer = 0;
        for (int i = 0; i <= N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }



}
