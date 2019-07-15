import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        int[] arr = {5,3,6,2,1,4};

        for (int i = 1; i <= arr.length; i++) {
            System.out.println(select(arr, 0, arr.length-1, i-1));
        }
    }

    static int select(int[] arr, int l, int r, int k)
    {
        if (l == r) return arr[l];

        int p = partition(arr, l, r);

        if (p == k) return arr[p];
        else if (k < p) return select(arr, l, p-1, k);
        else return select(arr, p+1, r, k);
    }

    static int partition(int[] arr, int l, int r)
    {
        int x = arr[r];
        int i = l;

        for (int j = l; j < r; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, r);
        return i;
    }

    static void swap(int[] arr, int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
