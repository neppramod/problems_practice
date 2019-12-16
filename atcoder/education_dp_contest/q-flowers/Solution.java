import java.util.*;

public class Solution
{

    static final int MAXN = 200010;
    static long bit[] = new long[MAXN];

    static int lowestsetbit(int x)
    {
        return x & (-x);   // -x in 2's complement (add 1 to 1's complement)
    }

    static long query(int x)
    {
        long answer = 0;
        while (x > 0) {
            answer = Math.max(answer, bit[x]);
            x -= lowestsetbit(x);
        }

        return answer;
    }

    static void update(int x, long value, int N)
    {
        while (x <= N) {
            bit[x] = Math.max(bit[x], value);
            x += lowestsetbit(x);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] h = new int[N+1];
        long[] a = new long[N+1];

        for (int i = 1; i <= N; i++) {
            h[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            a[i] = sc.nextLong();
        }

        long[] dp = new long[N+1];
        for (int i = 1; i <= N; i++) {
            dp[i] = query(h[i] - 1) + a[i];
            update(h[i], dp[i], N);
        }

        long best = 0;
        for (int i = 1; i <= N; i++) {
            best = Math.max(best, dp[i]);
        }

        System.out.println(best);

    }
}
