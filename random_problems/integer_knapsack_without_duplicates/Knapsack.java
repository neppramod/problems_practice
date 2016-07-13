import java.util.*;

/**
   The integer (0/1) knapsack problem

   Input: n items, with integer size Si and values Vi

   C: Knapsack capacity
   
   M(i,j) = Optimal value for filling exactly a capacity j knapsack with some subset of items 1..i

   M(i, j) = Max { M(i-1, j), M(i-1, j-Si) + Vi)}    // For first option ith item is not used, copied from row above it, for next item it uses ith value

   Create a 2D table, fill row 0 and column 0 with 0. Until you get a sum that is greater or equal to 0 using one of the items, use value from previous row
   If you find a new item, check its value by subtracting the size from previous row and add value for that item, if this amount is greater than value from previous row, replace it else use the value from previous row, same column.
 */

public class Knapsack
{
    static int knapsack(int[] S, int[] V, int C)
    {
        int[][] M = new int[S.length + 1][C + 1];

        for (int i = 0; i <= S.length; i++) {
            for (int j = 0; j <= C; j++) {
                if (i == 0 || j == 0) {
                    M[i][j] = 0;
                } else {
                    int max = M[i-1][j];

                    if (j - S[i-1] >= 0) {
                        max = Math.max(max, M[i-1][j-S[i-1]] + V[i-1]);   // S and V index starts from 0, therefore we do i-1 to adjust with M
                    }

                    M[i][j] = max;
                }
            }
        }

        System.out.println(Arrays.deepToString(M));

        return M[S.length][C];
    }

    public static void main(String[] args)
    {
        int[] S = {2, 3, 5, 7};
        int[] V = {3, 4, 6, 8};
        int C = 10;
        System.out.println(knapsack(S, V, C));
    }
}
