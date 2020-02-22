import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sum = amicables();
        System.out.println(sum);
    }

    static int amicables()
    {
        int sum = 0;
        for (int i = 1; i < 10000; i++) {
            int b = d(i);
            if (b < 10000 && d(b) == i && b != i) {
                sum += i;
            }
        }

        return sum;
    }

    static int[] div = new int[10000];

    static int d(int n)
    {
        if (div[n] != 0) {
            return div[n];
        } else {
            int sum = 0;

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                }
            }

            return div[n] = sum;
        }
    }
}
