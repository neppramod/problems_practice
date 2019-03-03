import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(countNSum(3,5));
    }

    static int countNSum(int n, int sum)
    {
        int total = 0;

        int N = (int)Math.pow(10,n);
        int start = N/10;
        for (int i = start; i < N; i++) {
            if (sumofdigits(i) == sum) total++;
        }

        return total;
    }

    static int sumofdigits(int i)
    {
        if (i < 10) return i;

        int sum = 0;
        while (i > 0) {
            sum += i%10;
            i/=10;
        }

        return sum;
    }
}
