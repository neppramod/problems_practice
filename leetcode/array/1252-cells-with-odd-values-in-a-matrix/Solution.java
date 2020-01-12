import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] indices = new int[][] {{0, 1}, {1, 1}};
        int result = oddCells(2, 3, indices);
        System.out.println(result);

    }

    public static int oddCells(int m, int n, int[][] indices) {
        int[][] trueMatrix = new int[m][n];

        for (int i = 0; i < indices.length; i++) {
            int r = indices[i][0];
            int c = indices[i][1];

            //System.out.printf("%d, %d\n", r, c);

            for (int k = 0; k < n; k++) {
                trueMatrix[r][k] += 1;
            }

            for (int k = 0; k < m; k++) {
                trueMatrix[k][c] += 1;
            }

            //trueMatrix[r][c] = trueMatrix[r][c]-1;  // invert double setting
        }

        // for (int i = 0; i < m; i++) {
        //    System.out.println(Arrays.toString(trueMatrix[i]));
        // }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += (trueMatrix[i][j] % 2 == 1)? 1 : 0;
            }
        }

        return count;

    }

}
