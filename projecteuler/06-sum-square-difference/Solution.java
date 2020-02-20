import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        long ans1 = naturalSquareSum(100);
        long ans2 = naturalSumSquare(100);

        System.out.println(Math.abs(ans1 - ans2));
    }

    static long naturalSquareSum(int n)
    {
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += (i * i);
        }
        return sum;
    }

    static long naturalSumSquare(int n)
    {
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }

        return sum * sum;
    }
}
