import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 2, 3};
        int k = 3;

        int result = subarraySum(arr, k);

        System.out.println(result);

    }

    public static int subarraySum(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int i = 0, j = 0, sum = 0;
        int N = arr.length;
        int count = 0;





        return count;
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
