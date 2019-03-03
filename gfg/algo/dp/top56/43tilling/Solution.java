import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] sum = new int[N+1];
        Arrays.fill(sum, 0);

        System.out.println(noOfWays(N, sum));
    }

    static int noOfWays(int N, int[] sum) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        if (N == 2) return 2;
        if (sum[N] != 0) return sum[N];
        sum[0] = 0;
        sum[1] = 1;
        sum[2] = 2;
        sum[N] = noOfWays(N-1, sum) + noOfWays(N-2, sum);
        return sum[N];
    }
}
