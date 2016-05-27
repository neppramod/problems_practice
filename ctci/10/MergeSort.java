import java.util.*;

public class MergeSort
{
    public static void sort(int[] A)
    {
        int[] B = new int[A.length];
        sort(A, B, 0, A.length - 1);
    }

    private static void sort(int[] A, int[] B, int low, int high)
    {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(A, B, low, mid);
            sort(A, B, mid + 1, high);
            merge(A, B, low, mid, high);
        }
    }

    private static void merge(int[] A, int[] B, int low, int mid,
                              int high)
    {

        for (int i = low; i <= high; i++) {
            B[i] = A[i];
        }


        int i = low;
        int j = mid + 1;
        int k = low;

        while(i <= mid && j <= high) {
            if(B[i] < B[j]) {
                A[k] = B[i];
                i++;
            } else {
                A[k] = B[j];
                j++;
            }

            k++;
        }


        // Copy remaining
        while (i <= mid) {
            A[k] = B[i];
            k++;
            i++;
        }
    }


    public static void main(String[] args)
    {
        int[] a = {9,3,5,4,7,5,3,7};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}

