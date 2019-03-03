/*
  Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against an opponent by alternating turns. In each turn, a player selects either the first or last coin from the
row, removes it from the row permanently, and receives the value of the coin. Determine the maximum possible amount of money we can definitely win if we move first.

 vi + Min(F(i+1,j-1), F(i+2,j))
 vj + Min(F(i+1,j-1), F(i, j-2));
*/


import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] v = { 20, 30, 2, 2, 2, 10 };
        System.out.println(optimalStrategyForGame(v));
    }

    static int optimalStrategyForGame(int[] v)
    {
        int n = v.length;
        int table[][] = new int[n][n];

        for (int gap=1; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++,j++) {
                int x = (i + 2 <= j) ? table[i+2][j] : 0;
                int y =(i + 1 <= j-1) ? table[i+1][j-1] : 0;
                int z = (i <= j-2) ? table[i][j-2] : 0;

                table[i][j] = Math.max (v[i] + Math.min(x,y), v[j] + Math.min(y,z));
            }
        }

        return table[0][n-1];
    }
}
