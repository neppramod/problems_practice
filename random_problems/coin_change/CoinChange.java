/**
 CoinChange: Number of minimum coins to get a particular target sum of coins
 M[j] denotes the minimum sum to get to jth coin
 Let denom[i] denote the coin that is used

 M[j] = Min { M(j-denom[i]) + 1} over all i

 What does it mean?

 Number of coins I use at a particular sum which ranges from 0 to the target sum is equal to minimum of valid sums of coins at a previous instance + 1
 
 Valid sum of coins at a previous instance = Minimum sum possible using all coins

 Example:
 denom[] = {1, 2, 5, 7}   // make sure one of those values is 1, because with 1 you can create any sum
 If my target sum is 12, I can create 12 using 5 and 7

 For sum 0, we use no denominator i.e. 0
 Sum 1: Use coin with value 1
 Sum 2: When using 1, 2-1 = 1, current value of 1 is 1, i.e 1+1 = 2
      : Next best thing to do would be 2-2 = 0, i.e 0+1 = 1
        We pick the minimum i.e 1. What it means is instead of using two 1 denominator coins, we used 1 two denominator coin.
 Sum 3: 3-1 = 2, Value of 2 is 1, i.ex 1+1 = 2, 3-2 = 1, 1+1 = 2, Both value are minimum
 Sum 4: 4-1 = 3 (2), 2+1 = 3, 4-2 = 2 (1) : 1+1 = 2, we use two 2 denom coins instead of three 1 denom.
 Sum 5: 5-1 = 4: 2+1 = 3, 5-2 = 3: 2+1 = 3, 5-5 = 0 + 1 = 1, we choose 1 5 denom coin
 Similarly:
Sum 6: 2 (5,1)
Sum 7: 1 (7)
Sum 8: 2 (7, 1)
Sum 9: 2 (7, 2)
Sum 10: 2 (Using two 5)
Sum 11: 3 (5,5,1), or (7, 2, 2)
Sum 12: 2 (7, 5)

Therefore, we return 2

Time complexity O(nm): For each sum to get minimum no. of coins, we have to loop through all of them to see which produces best result
Space complexity: O(n): We are using M, size of sum + 1
 */

import java.util.*;
public class CoinChange
{
    static int noOfChanges(int[] denom, int targetSum)
    {
        int[] M = new int[targetSum+1];
        M[0] = 0;

        for (int j = 1; j <= targetSum; j++) {
            int min = Integer.MAX_VALUE;
            
            for (int i = 0; i < denom.length; i++) {
                int sum = j-denom[i];
                if (sum >= 0) {
                    min = Math.min(min, M[sum]) + 1;
                }
            }            
            M[j] = min;
        }

        System.out.println(Arrays.toString(M));

        return M[targetSum];
    }

    public static void main(String[] args)
    {
        int[] denoms = {1, 2, 5, 7};
        System.out.println(noOfChanges(denoms, 12));
    }
}
