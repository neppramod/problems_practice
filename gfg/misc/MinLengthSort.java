import java.util.*;


// Its wrong, gives -4
public class MinLengthSort
{
    static int minlengthsort(int[] arr)
    {
        int s = 0;
        int N = arr.length;
        int e = N-1;

        for (int i = 0; i < N-1; i++) {
            if (arr[i] < arr[i+1])
                s = i;
        }

        for (int i = N-1; i > 0; i--) {
            if (arr[i] < arr[i-1])
                e = i;
        }

        int max = arr[s];
        int min = arr[s];
        for (int i = s+1; i <=e; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }

        if (arr[s] > min) {
            while (s >= 0 && arr[s] > min)
                s--;
        }

        if (arr[e] < max) {
            while (e <= N-1 && arr[s] < max)
                e++;
        }

        if (s != e) {
            return e-s+1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        System.out.println(minlengthsort(arr));
    }
}
