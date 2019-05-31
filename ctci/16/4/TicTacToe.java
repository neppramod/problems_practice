import java.util.*;

public class TicTacToe
{
    static boolean win(int[][] matrix, int turn)
    {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean won = false;
        int[] rows = new int[m];
        int[] cols = new int[n];
        int[] diag = new int[2];

        for (int i = 0; i <= m-1; i++) {
            for (int j = 0; j <= n-1; j++) {
                if (i == j && matrix[i][j] == turn) diag[0] = diag[0] + 1;
                if (i == n-1-j && matrix[i][j] == turn) diag[1] = diag[1] + 1;
                if (matrix[i][j] == turn) rows[i] = rows[i] + 1;
                if (matrix[i][j] == turn) cols[j] = cols[j] + 1;
            }
        }

        for (int i = 0; i < m; i++) {
            if (rows[i] == m) return true;
        }

        for (int i = 0; i < n; i++) {
            if (cols[i] == n) return true;
        }

        for (int i = 0; i < 2; i++) {
            if (diag[i] == m) return true;
        }

        return false;
    }

    public static void main(String[] args)
    {
        int[][] matrix = {{-1, 1, 1, -1},
                          {1, 1, 1, 1},
                          {1, 1, -1, -1},
                          {1, -1, -1, -1},
        };
        System.out.println(win(matrix, 1));
    }
}
