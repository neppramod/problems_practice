import java.util.*;
import java.math.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long C = sc.nextLong();
        int[] h = new int[N+1];

        for (int i = 1; i <= N; i++) {
            h[i] = sc.nextInt();
        }

        BigDecimal[] dp = new BigDecimal[N+1];

        dp[0] = new BigDecimal(0);
        dp[1] = new BigDecimal(0);

        for (int i = 2; i <= N; i++) {
            BigDecimal ans = new BigDecimal(Long.MAX_VALUE);
            for (int j = 1; j < i; j++) {
                BigDecimal diff = new BigDecimal(h[i] - h[j]);
                BigDecimal ans1 = diff.multiply(diff).add(new BigDecimal(C)).add(dp[j]);
                ans = ans1.compareTo(ans) > 0 ? ans : ans1;
            }
            dp[i] = ans;
        }

        System.out.println(dp[N].toString());
    }
}
