import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        int result = equilibrium(arr);
        System.out.println(result);
    }

    static int equilibrium(int[] arr)
    {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int left = 0;
        for (int i = 0; i < n; i++) {
            sum -= arr[i];

            if (sum == left) {
                return i;
            }

            left += arr[i];
        }

        return -1;
    }
}
