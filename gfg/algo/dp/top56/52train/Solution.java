/**

52 train


Recurrance relation

minCost(cost, 0, n-1) = Min (cost[0][n-1], minCost(cost, 0, n-2) + minCost(cost, n-2, n-1), ...)
 */

import java.util.*;

public class Solution
{
    static final int INF = Integer.MIN_VALUE;
    static int N = 4;
    static int cycle = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cost[][] = { {0, 15, 80, 90},
                         {INF, 0, 40, 50},
                         {INF, INF, 0, 70},
                         {INF, INF, INF, 0}
        };

        long cuttime = System.currentTimeMillis();

        System.out.println("The Minimum cost to reach station "+ N+
                           " is "+minCost(cost));

        System.out.println(System.currentTimeMillis() - cuttime);


    }


    static int minCost(int[][] cost)
    {
        int[] sum = new int[N];
        Arrays.fill(sum, Integer.MAX_VALUE);
        sum[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (sum[i] + cost[i][j] < sum[j]) sum[j] = sum[i] + cost[i][j];
            }
        }


        return sum[N-1];
    }

    static int minCost1(int[][] cost)
    {
        int[] val = new int[N];
        Arrays.fill(val, Integer.MAX_VALUE);
        return minCostRec(cost, 0, cost.length-1, val);
    }

    static int minCostRec(int[][] cost, int s, int d, int[] val)
    {

        if (s == d || (s+1) == d) return cost[s][d];

        if (val[s] != Integer.MAX_VALUE) return val[s];


        int min = cost[s][d];

        for (int i = s+1; i < d; i++) {
            int c = minCostRec(cost, s, i, val) + minCostRec(cost, i, d, val);
            if (c < min) min = c;
        }

        val[s] = min;

        return min;
    }
}
