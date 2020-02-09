import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] grid = {"11111".toCharArray(),
                         "11011".toCharArray(),
                         "11101".toCharArray(),
                         "11111".toCharArray()};

        int result = numIslands(grid);

        System.out.println(result);

    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += numIslands(grid, visited, i, j);
            }
        }

        return count;
    }
    static int[][] moves = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    static int numIslands(char[][] grid, boolean[][] visited, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n) {
            return 0;
        } else if (visited[r][c]) {
            return 0;
        } else if (grid[r][c] == '0') {
            visited[r][c] = true;
            return 0;
        } else {
            visited[r][c] = true;
            int count = 1;

            // ignore other values, but traverse to set visited
            for (int i = 0; i < 4; i++) {
                numIslands(grid, visited, r + moves[i][0], c + moves[i][1]);
            }
            return count;
        }
    }

    static void pA1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println();
    }

    static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pA1(arr[i]);
        }
    }
}
