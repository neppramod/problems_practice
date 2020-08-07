import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 3;
        System.out.println(Arrays.toString(sumZero(n)));
    }

    public static int[] sumZero(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n/2; i++) {
            arr[i] = i + 1;
            arr[n-i-1] = -arr[i];
        }


        return arr;
    }

}
