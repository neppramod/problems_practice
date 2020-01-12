import java.util.*;

/*
Remove duplicates from sorted array
*/

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 1, 3, 3, 3, 3, 5, 6};

        System.out.println(new Solution().removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));

    }


    public int removeDuplicates(int[] arr) {
        int i = 0, j = i+1;
        int N = arr.length;

        while (j < N) {
            if (arr[i] != arr[j]) {
                swap(arr, i+1, j);
                i++;
            }
            j++;
        }

        return i+1;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
