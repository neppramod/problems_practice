import java.util.*;

/*

  Fix for 0 in the beginning and in middle
  E.g.

  120
  23121312321
  112211113333
  121020
  0

  output:
  1
  60
  55
  2
*/


public class Acode
{
    static int combi(String input)
    {
        int N = input.length();
        int[] dp = new int[N+1];

        if (N == 0) return 0;
        else if (N == 1) return 1;

        dp[0] = 1;  // have to handle this edge case, although invalid
        dp[1] = 1;


        for (int i = 2; i <= N; i++) {
            int cur = Integer.valueOf(input.charAt(i-2) + "" + input.charAt(i-1));
            if (cur <= 26 && cur > 10 && cur % 10 != 0)
                dp[i] = dp[i-2] + dp[i-1];
            else
                dp[i] = dp[i-1];
        }

        return dp[N];
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String input = sc.next();
            if ("0".equals(input)) break;
            System.out.println(combi(input));
        }
    }
}
