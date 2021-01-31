import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int max = maxCollatz(MAX);
        collatz[1] = 1;
        collatz[2] = 2;
        collatz[3] = 4;

        System.out.println(max);

        //System.out.println(count(837799));
        //System.out.println(count(13));
    }

    static final int MAX = 1000000;
    static int[] collatz = new int[MAX];

    static int maxCollatz(int n) {
        int max = 0;
        int maxNumber = 0;
        for (int i = 1; i < n; i++) {
            //System.out.println("Max at: " + i);
            //max = Math.max(max, count(i));
            int cur = count(i);
            if (cur > max) {
                max = cur;
                maxNumber = i;
            }

        }

        return maxNumber;
    }

    static int count(int n)
    {
        //if (collatz[n] > 0) {
        //    return collatz[n];
        //} else {
            int count = 1;
            int initialn = n;
            while (n > 1) {
                if (n % 2 == 0) {
                    n = n/2;
                } else {
                    n = 3 * n + 1;
                }
                count++;
            }
            //return collatz[initialn] = count;
            //}
            return count;
    }
}
