import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {4, 2, 5, 7};

        int[] result = sortArrayByParityII(arr);

        System.out.println(Arrays.toString(result));

    }

    public static int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int[] B = new int[n];

        int i = 0, j = 1, k = 0;

        while (k < n) {
            if (A[k] % 2 == 0) {
                B[i] = A[k];
                i += 2;
            } else {
                B[j] = A[k];
                j += 2;
            }
            k++;
        }

        return B;
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
