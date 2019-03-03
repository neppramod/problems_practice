import java.util.*;

public class Solution
{
    static int c1,c2;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(rodCutting(N));
        System.out.println(rodCuttingDP(N));
        System.out.printf("C1: %d, C2: %d\n", c1, c2);
    }

    static int rodCutting(int N)
    {
        if (N <= 0) return 0;

        int res = 0;
        for (int i = 1; i <= N; i++) {
            int cur = Math.max(i * (N-i), i*rodCutting(N-i));
            if (cur > res) res = cur;
        }

        c1++;
        return res;
    }

    static int rodCuttingDP(int N)
    {
        if (N <= 0) return 0;
        int dp[] = new int[N+1];
        Arrays.fill(dp, 0);
        dp[0] = 0;


        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= i; j++) {
                int cur = j * (i-j);
                if (i-j >= 0) {
                    cur = Math.max(cur, j * dp[i-j]);
                }

                dp[i] = Math.max(cur, dp[i]);

                c2++;

            }
        }

        return dp[N];
    }
}
