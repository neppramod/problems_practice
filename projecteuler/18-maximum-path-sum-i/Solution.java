import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] triangle = getTriangle();

        int sum = maxPathSum(triangle);
        System.out.println("Sum: " + sum);
    }

    static final int MAX = 15;

    static int[][] getTriangle()
    {
        int[][] arr = new int[4][4];
        arr[0][2] = 3;
        arr[1][1] = 7;
        arr[1][2] = 4;
        arr[2][1] = 2;
        arr[2][2] = 4;
        arr[2][3] = 6;
        arr[3][0] = 8;
        arr[3][1] = 5;
        arr[3][2] = 9;
        arr[3][3] = 3;

        printArr(arr);

        return arr;
    }

    static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    static int maxPathSum(int[][] arr)
    {
        int n = arr.length;


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left = (j > 0 ? arr[i-1][j-1] : 0);
                int right = (j < n-1 ? arr[i-1][j+1] : 0);
                arr[i][j] = Math.max(left, right) + arr[i][j];
            }
        }

        int max = 0;
        for (int j = 0; j < n; j++) {
            max = Math.max(max, arr[n-1][j]);
        }

        return max;
    }
}
