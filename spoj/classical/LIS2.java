import java.util.*;

public class LIS2
{
    static int lis(int[][] pair)
    {
        int N = pair.length;
        int[] sum = new int[N+1];
        sum[0] = 1;

        for (int i = 1; i < N; i++) {
            if (pair[i][0] > pair[i-1][0] && pair[i][1] > pair[i-1][1]) {
                sum[i] = sum[i-1] + 1;
            } else {
                sum[i] = sum[i-1];
            }
        }

        return sum[N-1];
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] arr = new int[T][2];
        for (int t = 0; t < T; t++) {
            arr[t][0] = sc.nextInt();
            arr[t][1] = sc.nextInt();
        }

        System.out.println(lis(arr));
    }
}
