import java.util.*;

// LIS
public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);  // All indixes are at least 1 length

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int best = 0;
        for (int i = 0; i < N; i++) {
            best = Math.max(best, dp[i]);
        }
        System.out.println(best);
    }
}
