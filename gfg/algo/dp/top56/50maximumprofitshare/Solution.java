/**
price[] = [2, 30, 15, 10, 8, 25, 80]
profit[] =[78, 100,  100,  72,  72,  55,  0]  i = 1

72 + 30-2 = 72 + 28 = 100
72 + 15-2

max_price = 2

 */

import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] price = {2, 30, 15, 10, 8, 25, 80};
        System.out.println(getMaxProfit(price));
    }

    static int getMaxProfit(int[] price)
    {
        int N = price.length;
        int[] profit = new int[N];

        int max_profit = price[N-1];
        for (int i = N-2; i >= 0; i--) {
            if (price[i] > max_profit) max_profit = price[i];

            profit[i] = Math.max(profit[i+1], max_profit-price[i]);
        }

        int min_profit = price[0];
        for (int i = 1; i < N; i++) {
            if (price[i] < min_profit) min_profit = price[i];

            profit[i] = Math.max(profit[i-1], profit[i] + price[i] - min_profit);
        }

        return profit[N-1];
    }
}
