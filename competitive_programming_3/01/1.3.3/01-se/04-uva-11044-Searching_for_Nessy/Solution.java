/**
   11044 - Searching for Nessy

   Given a grid of n rows and m columns representing the
   loch, 6 ≤ n, m ≤ 10000, find the minimum number s of sonar
   beams you must put in the square such that we can control
   every position in the grid, with the following conditions:
   • one sonar occupies one position in the grid; the sonar
   beam controls its own cell and the contiguous cells;
   • the border cells do not need to be controlled, because
   Nessy cannot hide there (she is too big).
 */

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int xr = x / 3;
            int yr = y / 3;

            System.out.println(xr * yr);
        }
    }
}
