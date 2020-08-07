import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        int[][] mat = {{11,25,66,1,69,7},{23,55,17,45,15,52},{75,31,36,44,58,8},{22,27,33,25,68,4},{84,28,14,11,5,50}};

        int[][] result = diagonalSort(mat);

        pA2(result);

    }

    public static int[][] diagonalSort(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;

        for (int i = 0; i < C; i++) {
            sortDiagonal(0, i, mat);
        }

        for (int i = 1; i < R; i++) {
            sortDiagonal(i, 0, mat);
        }

        return mat;
    }

    static void sortDiagonal(int r, int c, int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        int len = Math.min(M-r, N-c);
        int[] arr = new int[len];
        int i = 0;
        int r1 = r, c1 = c;
        while (r1 < M && c1 < N) {
            arr[i] = mat[r1][c1];
            r1++;
            c1++;
            i++;
        }

        Arrays.sort(arr);

        int r2 = r, c2 = c;
        i = 0;
        while (r2 < M && c2 < N) {
            mat[r2][c2] = arr[i];
            r2++;
            c2++;
            i++;
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
