import java.util.*;

public class Frog
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int[] h = new int[N];

        for (int i = 0; i < N; i++) {
            h[i] = sc.nextInt();
        }

        printMinTotal(h);
    }

    private static void printMinTotal(int[] h)
    {
        int N = h.length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j <= i+2; j++) {
                if (j < N) {
                    dp[j] = Math.min(dp[j], dp[i] + Math.abs(h[i] - h[j]));
                }
            }
        }

        System.out.println(dp[N-1]);
    }
}
