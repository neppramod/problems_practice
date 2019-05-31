import java.util.*;

public class PondSize
{
    static int countPond(int[][] matrix)
    {
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    fill(matrix, i, j);
                    count++;
                }
            }
        }


        return count;
    }

    static void fill(int[][] matrix, int i, int j)
    {
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0) return;
        if (matrix[i][j] == 0) {
            matrix[i][j] = -1;
            fill(matrix, i+1, j);
            fill(matrix, i, j+1);
        } else {
            return;
        }
    }

    public static void main(String[] args)
    {
        int[][] matrix = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        int ponds = countPond(matrix);
        System.out.println("Pond size: " + ponds);
    }

}
