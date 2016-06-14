/**
   Given a number of coins find ways to get to represent a total.

   Let's say we have coins of denominator 5, 10, 25. How many ways we can represent 100.

   Algorithm.

   We need to build up from base 0 sum to all the ways we can get up to 100. I.e We find out how many ways we can get a sum of 0 using above. We use 1 for the base case. We then build for all the sums until we get to the total.

   We iterate through each coin and build up all the ways we can get to each sum from 0 to 100.
   Next time we pick up another coin and sum the value we got at the index  + the value at this coin values down the line (before). i.e If coins[j] is current coin i.e say 10 then we add to current sum the value we got at [currentIndex - currentCoinValue]. or [i - 10]. I.e. We found a new way to represent the coins and we can use dynamic programming (save value at previous location and use it) to build up current value.
 */


public class Coins
{
    
    public static int numberOfWays(int total, int[] coins)
    {
        int[] sum = new int[total + 1];
        sum[0] = 1; // base case

        for (int i = 0; i < coins.length; i++) {  // be careful, in above example i is used for next iterator (current sum, here i is used for coin index)
            for (int j = 0; j <= total; j++) {  // here we build up to index total, and our sum array index can go upto total index
                if (j >= coins[i]) {            // if we finally found a sum that can be represented by one of the coins (or given coin at this instance)
                                                // we add number of ways
                    
                    sum[j] += sum[j-coins[i]];   // Since we have already calculated the number of ways to get a sum at
                                                 // index j - coins[i] (current sum - current coin index before
                                                 //, we can use that

                }
            }
        }

        return sum[total];
    }

    public static void main(String[] args)
    {
        int total = 15;
        int coins[] = {3,4,6,7,9};
        System.out.println(numberOfWays(total, coins));
        System.out.println(numberOfWays(100, new int[] {15,10,5,25}));
    }
}
