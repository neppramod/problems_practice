import java.util.*;

/* C - Vacation */

public class Taro
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[3]; // only need to save previous state

        Arrays.fill(dp, 0);


        for (int days = 0; days < N; days++) {
            int[] new_dp = new int[3]; // only need to save current state
            Arrays.fill(new_dp, 0);

            // get cost
            int[] cost = new int[3];
            for (int i = 0; i < 3; i++) {
                cost[i] = sc.nextInt();
            }


            // i,j will make sure no two consecutive activities  follow

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != j) {
                        new_dp[j] = Util.max(new_dp[j], dp[i] + cost[i]);
                    }
                }
            }

            dp = new_dp;
        }


        System.out.println(Util.max(dp));

    }
}
