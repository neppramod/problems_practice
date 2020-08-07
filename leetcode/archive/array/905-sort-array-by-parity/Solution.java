import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {3, 1, 2, 4};
         sortArrayByParity(arr);

         System.out.println(Arrays.toString(arr));

    }

    public static int[] sortArrayByParity(int[] A) {

        int i = 0, j = 0, N = A.length;

        while (j < N) {

            if ((A[i]%2 == 1) && (A[j] % 2 == 0)) {
                swap(A, i, j);
                i++;
            } else if (A[i] % 2 == 0) {
                i++;
            }

            j++;
        }

        return A;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
