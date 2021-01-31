import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {2, 0, 2, 1, 1, 0};

        sortColors(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void sortColors(int[] arr) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeros++;
            } else if (arr[i] == 1) {
                ones++;
            } else {
                twos++;
            }
        }

        int i = 0;
        while (i < zeros) {
            arr[i] = 0;
            i++;
        }

        int j = 0;
        while (j < ones) {
            arr[i] = 1;
            i++;
            j++;
        }

        j = 0;
        while (j < twos) {
            arr[i] = 2;
            i++;
            j++;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
