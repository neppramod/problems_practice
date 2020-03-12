class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        return uniquePathsWithObstacles(obstacleGrid, 0, 0, dp, visited);
    }

    int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j, int[][] dp, boolean[][] visited) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (i == m-1 && j == n-1 && obstacleGrid[i][j] != 1) {
            return 1;
        } else if (i >= m || j >= n) {
            return 0;
        } else if (visited[i][j]) {
            return dp[i][j];
        } else {
            visited[i][j] = true;
            if (obstacleGrid[i][j] == 1) {
                dp[i][j] = 0;
            } else {
                dp[i][j] = uniquePathsWithObstacles(obstacleGrid, i + 1, j, dp, visited)  + uniquePathsWithObstacles(obstacleGrid, i, j+1, dp, visited);
            }
            return dp[i][j];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix ={
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println(sol.uniquePathsWithObstacles(matrix));
    }
}
