/**
   UVa 11172 - Relational Operators
   Can you help
   Michael choose a place to park which minimises the distance he needs to
   walk on his shopping round?

   (highest - lowest) * 2 => he has to walk both ways from center and come back


   Sample Input
   2
   4
   24 13 89 37
   6
   7 30 41 14 39 42

   Sample Output
   152
   70
*/

import java.util.*;
import java.text.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int min = 100;
            int max = -1;

            while (n-- > 0) {
                int cur = sc.nextInt();
                if (cur > max) {
                    max = cur;
                }

                if (cur < min) {
                    min = cur;
                }
            }

            System.out.println((max - min) * 2);
        }
    }
}
