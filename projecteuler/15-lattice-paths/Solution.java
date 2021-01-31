import java.util.*;


// TODO: Not Done
public class Solution
{
    public static void main(String[] args) {

        int M = 20;
        int N = 20;

        int[][] dp = new int[M+2][N+2];
        int count = numberOfPaths(M+1, N+1, dp);
        //int count2 = numPath(M+1, N+1);
        System.out.println(count);
        //System.out.println(count2);

    }

    static int numberOfPaths(int m, int n, int[][] dp)
    {
        if (dp[m][n] != 0) {
            return dp[m][n];
        } else if (m == 1 || n == 1) {
            return 1;
        } else {
            return dp[m][n] = (numberOfPaths(m-1, n, dp) + numberOfPaths(m, n-1, dp));
        }
    }

    static int numPath(int m, int n)
    {
        if (m == 1 || n == 1) {
            return 1;
        } else {
            return numPath(m-1, n) + numPath(m, n-1);
        }
    }




}
