import java.util.*;

// Using Hoare's partition scheme
// https://en.wikipedia.org/wiki/Quicksort

public class QuickSort
{
    public static void quicksort(int[] A, int lo, int hi)
    {
        if (lo < hi) {
            int p = partition(A, lo, hi);
            quicksort(A, lo, p-1);
            quicksort(A, p+1, hi);
        }
    }

    private static int partition(int[] A, int lo, int hi)
    {
        int pivot = A[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (A[j] <= pivot) {
                swap(A, i, j);
                i++;
            }
        }

        swap(A, i, hi);
        return i;
    }

    private static void swap(int[] A, int i, int j)
    {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args)
    {
        int[] array = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));


        int[] array2 = {
            10, 9, 6, 10, 9, 5, 4, 8, 7, 6,
            8, 9, 1, 7, 3, 2, 8, 5, 10, 7,
            1, 2, 8, 9, 8, 6, 7, 7, 9, 3,
            1, 5, 8, 5, 7, 5, 5, 1, 1, 9,
            6, 10, 4, 5, 1, 8, 9, 8, 4, 10,
            1, 6, 3, 9, 7, 9, 2, 9, 8, 4,
            5, 9, 3, 10, 2, 7, 8, 7, 4, 2,
            9, 5, 5, 8, 6, 4, 2, 2, 5, 6,
            4, 2, 3, 3, 3, 8, 1, 10, 6, 5,
            9, 9, 4, 8, 7, 4, 1, 4, 9, 7
        };


        quicksort(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));
    }
}
