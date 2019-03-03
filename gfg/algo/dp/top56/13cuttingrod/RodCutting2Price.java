import java.util.*;

public class RodCutting2Price
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(getMaxPrice(arr, arr.length));

    }

    static int getMaxPrice(int[] price, int N)
    {
        if (N <= 0) return 0;

        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, getMaxPrice(price, N-i-1) + price[i]);
        }

        return res;
    }
}
