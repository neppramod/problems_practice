import java.util.*;

public class Solution
{
    static int R = 3;
    static int C = 3;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] points = { {-2,-3,3},
                             {-5,-10,1},
                             {10,30,-5}};

       int minPoints =  minInitialPoints(points);
       System.out.println(minPoints);

    }

    static int minInitialPoints(int[][] points)
    {
        int m = R;
        int n = C;

        int[][] dp = new int[m][n];
        dp[m-1][n-1] = points[m-1][n-1] > 0 ? 1 : Math.abs(points[m-1][n-1]) + 1;

        for (int i = m-2; i >= 0; i--) {
            dp[i][n-1] = Math.max(dp[i+1][n-1] - points[i][n-1], 1);
        }

        for (int j = n-2; j >= 0; j--) {
            dp[m-1][j] = Math.max(dp[m-1][j+1] - points[m-1][j], 1);
        }

        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                int cur_min = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(cur_min-points[i][j], 1);
            }
        }

        return dp[0][0];
    }
}
