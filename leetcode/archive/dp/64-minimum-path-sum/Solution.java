import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] matrix = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        int result = minPathSum(matrix);

        System.out.println(result);

    }

    static int minPathSum(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        // sum first row and col
        for (int j = 1; j < N; j++) {
            matrix[0][j] += matrix[0][j-1];
        }

        for (int i = 1; i < M; i++) {
            matrix[i][0] += matrix[i-1][0];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1]) + matrix[i][j];
            }
        }

        // for (int i = 0; i < M; i++) {
        //    System.out.println(Arrays.toString(matrix[i]));
        //}

        return matrix[M-1][N-1];
    }
}
