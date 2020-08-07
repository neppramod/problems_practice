import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] arr = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        flipAndInvertImage(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }

    public static int[][] flipAndInvertImage(int[][] A) {
        flipHorizonally(A);
        invert(A);

        return A;
    }

    static void flipHorizonally(int[][] A) {
        int M = A.length;
        int N = A[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N/2; j++) {
                int tmp = A[i][j];
                A[i][j] = A[i][N-j-1];
                A[i][N-j-1] = tmp;
            }
        }
    }

    static void invert(int[][] A) {
        int M = A.length;
        int N = A[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = A[i][j] == 0 ? 1 : 0;
            }
        }
    }

}
