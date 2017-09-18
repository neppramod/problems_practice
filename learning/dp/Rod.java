import java.util.*;
public class Rod
{
    public static int revenue(int N, int[] prices)
    {
        int[] sum = new int[N + 1]; // all will be initialized to 0
        sum[0] = 0; // base case
        sum[1] = prices[0];  // assume prices[1] has price for index 1

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                sum[i] = Math.max(sum[i - j - 1] + prices[j], sum[i]);
            }
        }

        return sum[N];
    }


    public static void main(String[] args)
    {
        int[] prices = {2, 3, 3, 4, 7, 7};
        int N = 6;
        System.out.println(revenue(N, prices));
    }
}
