import java.util.*;

public class Coins2
{
    public int noOfWays(int n, int[] denoms)
    {
//int denoms = {25, 10, 5, 1};
        int[][] memo = new int[n+1][denoms.length];
        int ways = noOfWays(n, denoms, 0, memo);

        //printmemo(memo);
        return ways;
    }

    public void printmemo(int[][] memo)
    {
        for (int i = 0; i < memo.length; i++) {
            System.out.println(i + " : " + Arrays.toString(memo[i]));
        }
    }


    int noOfWays(int amount, int[] denoms, int index, int[][] memo)
    {
        if (memo[amount][index] > 0) {
            return memo[amount][index];
        }

        if (index >= denoms.length - 1)
            return 1;

        int ways = 0;
        int denomAmount = denoms[index];

        for (int i = 0; i * denomAmount <= amount; i++) {
            int remaining = amount - i * denomAmount;
            ways += noOfWays(remaining, denoms, index + 1, memo);
        }

        memo[amount][index] = ways;
        return ways;
    }


    public static void main(String[] args)
    {
        int total = 15;
        int coins[] = {3,4,6,7,9};
        Coins2 cc = new Coins2();
        System.out.println(cc.noOfWays(total, coins));
        System.out.println(cc.noOfWays(100, new int[] {15,10,5,25}));
    }

}

