import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // int[] arr = {3, 2, 2, 3};
        //System.out.println(removeElement(arr, 3));

        int[] arr = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr, 2));

        //swiftLeft(arr, 1);
        //swiftLeft(arr, 2);
        //swiftLeft(arr, 2);
        System.out.println(Arrays.toString(arr));

    }

    static public int removeElement(int[] arr, int val) {
        int i = 0, j = i;
        int count = 0;
        int N = arr.length;
        while (j < N && i < N) {

            if (arr[j] != val) {
                count++;
            }

            if (arr[i] == val && arr[j] != val) {
                swap(arr, i, j);
            }

            j++;
            if (arr[i] != val) {
                i++;
            }
        }

        return count;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
