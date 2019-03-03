import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println(getMaxAs(N));
        System.out.println(getMaxAsDP(N));
    }

    static int getMaxAs(int N)
    {
        if (N < 7) return N;
        int max = 0;
        for (int b = N-3; b >= 1; b--) {
            int cur = (N-b-1) * getMaxAs(b);
            if (cur > max) max = cur;
        }

        return max;
    }

    /*
      N = 9
      b = 6, b >= 1, b--
      max = 12;

      b=6, cur = 2 * getMaxAs(6) 12
      b = 5, cur = 3 * getMaxAs(5) = 15
      b = 4, cur = 4 * 4 = 16
     */

    static int getMaxAsDP(int N)
    {
        int[] screen = new int[N];

        for (int i = 1; i < 7; i++) {
            screen[i-1] = i;
        }

        for (int i = 7; i <= N; i++) {
            screen[i-1] = 0;

            for (int b = i-3; b >= 1; b--) {
                int cur = (i-b-1) * screen[b-1];
                if (cur > screen[i-1]) screen[i-1] = cur;
            }
        }

        return screen[N-1];
    }
}
