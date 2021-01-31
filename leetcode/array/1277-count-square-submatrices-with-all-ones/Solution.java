import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] arr =
            {
            {0,1,1,1},
            {1,1,1,1},
            {0,1,1,1}
            };

        int[][] prefixSums = new int[arr.length][arr[0].length];
        calcPrefixSums(arr, prefixSums);
        int result = countOneSquares(prefixSums);
        System.out.println(result);
        print2DArr(prefixSums);
    }

    static void print2DArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    static void calcPrefixSums(int[][] arr, int[][] prefixSums) {
        int m = arr.length;
        int n = arr[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixSums[i][j] += arr[i][j];
                if (i > 0) {
                    prefixSums[i][j] += prefixSums[i-1][j];
                }

                if (j > 0) {
                    prefixSums[i][j] += prefixSums[i][j-1];
                }
            }
        }
    }

    static int countOneSquares(int[][] prefixSums)
    {
        int sum = 0;
        int m = prefixSums.length;
        int n = prefixSums[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = Math.min(i, j);
                while (k >= 0) {
                    int sqSum = squareSum(prefixSums, i, j, k);
                    if (sqSum == (k + 1) * (k + 1)) {
                        sum++;
                    }
                    k--;
                }
            }
        }

        return sum;
    }

    static int squareSum(int[][] arr, int i, int j, int offset)
    {
        int sum = 0;
        for (int k = i-offset; k <= i; k++) {
            for (int l = j - offset; l <= j; l++) {
                sum += arr[k][l];
            }
        }

        return sum;
    }
}
