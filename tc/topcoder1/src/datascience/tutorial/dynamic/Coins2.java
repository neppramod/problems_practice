import java.util.*;

public class Coins2
{
    public static int minCoins2(int N, int[] coins)
    {
        int[] sum = new int[N + 1];
        Arrays.fill(sum, Integer.MAX_VALUE);
        sum[0] = 0;

        for (int j = 0; j < coins.length; j++) {
            for (int i = 0; i <= N; i++) {
                if (i + coins[j] <= N && sum[i + coins[j]] > sum[i] + 1) {
                    sum[i + coins[j]] = sum[i] + 1;
                }
            }
        }

        System.out.println(Arrays.toString(sum));
        return sum[N];
    }

    public static int minCoins1(int N, int[] coins)
    {
        int[] sum = new int[N + 1];
        Arrays.fill(sum, Integer.MAX_VALUE);
        sum[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && sum[i-coins[j]] + 1 < sum[i])
                    sum[i] = sum[i-coins[j]] + 1;
            }
        }
        System.out.println(Arrays.toString(sum));
        return sum[N];
    }

    public static void main(String[] args)
    {
        System.out.println(minCoins2(11, new int[] {1, 3, 5}));
        System.out.println(minCoins1(11, new int[] {1, 3, 5}));
    }
}
