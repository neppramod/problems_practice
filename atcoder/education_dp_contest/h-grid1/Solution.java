import java.util.*;

public class Solution
{
    static long MOD = 1000000000 + 7;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        char[][] grid = new char[H+1][W+1];   // follow one 0 or 1 based indexing, adjust boundaries accordingly

        for (int i = 1; i <= H; i++) {
            String s = sc.next();
            for (int j = 1; j <= W; j++) {
                grid[i][j] = s.charAt(j-1);
            }
        }

        boolean[][] visited = new boolean[H+1][W+1];
        long[][] dp = new long[H+1][W+1];

        System.out.println(count(grid, 1, 1, H, W, dp, visited));
    }

    static long count(char[][] grid, int i, int j, int H, int W, long[][] dp, boolean[][] visited) {
        if (i > H || j > W || grid[i][j] == '#') {
            return 0;
        } else if (i == H && j == W) {
            return 1;
        } else if (visited[i][j]) {
            return dp[i][j];
        } else {
            visited[i][j] = true;
            return dp[i][j] = (count(grid, i+1, j, H, W, dp, visited) + count(grid, i, j+1, H, W, dp, visited)) % MOD;
        }
    }
}
