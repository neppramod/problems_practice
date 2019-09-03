import java.util.*;

public class KnapSack1errichto
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int W = sc.nextInt();
        long[] dp = new long[W+1];

        for (int item = 0; item < N; item++) {
            int wt = sc.nextInt();
            long val = sc.nextLong();

            for (int weight_already = W - wt; weight_already >= 0; weight_already--) {
                dp[weight_already + wt] = Util.max(dp[weight_already + wt], dp[weight_already] + val);
            }
        }

        System.out.println(Util.max(dp));
    }
}
