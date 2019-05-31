import java.util.*;

public class BinarySearch
{
    public static void main(String[] args)
    {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 8, 9, 10};
        int n = arr.length;
        int start = 0;
        System.out.println(binarySearchMissing(arr, start, n-1));
    }

    static int binarySearchMissing(int[] arr, int start, int end)
    {
        if (start < end) {
            int mid = (start + end) / 2;
            if (mid == arr[mid]) {
                return binarySearchMissing(arr, mid+1, end);
            } else {

                return binarySearchMissing(arr, start, mid-1);
            }
        }

        if (end - start == 1) return arr[start] + 1;

        return -1;
    }
}
