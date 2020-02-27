// Convert array into zigzag fashion
// a < b > c < d > e < f.

import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = {4, 3, 7, 8, 6, 2, 1};

        zigzagConversion(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void zigzagConversion(int[] a)
    {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            if (i % 2 == 0) {
                if (a[i+1] < a[i]) {
                    swap(a, i , i+1);
                }
            } else {
                if (a[i+1] > a[i]) {
                    swap(a, i, i+1);
                }
            }
        }
    }

    static void swap(int[] arr, int i, int j)
    {
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
