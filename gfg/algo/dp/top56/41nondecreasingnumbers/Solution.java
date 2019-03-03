import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(totalNonDecreasingDigits(sc.nextInt()));

    }

    static int totalNonDecreasingDigits(int N)
    {
        int limitNumber = (int)(Math.pow(10, N));
        int sum = 1;
        for (int i = 1; i < limitNumber; i++) {
            if (isnondecreasing(i)) sum++;
        }

        return sum;
    }

    static boolean isnondecreasing(int i)
    {
        if (i < 10) return true;
        while (i > 0) {
            if (i%10 < (i/10)%10) return false;
            i/=10;
        }

        return true;
    }

    static int countNonDecreasingDigits(int n)
    {
        int N = 10;
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= (i+N-1);
            ans /= i;
        }

        return ans;
    }
}

/*
n=2

  ans = n * (n+1) * (n+2) * (n+N-1) / (1 * 2 * 3 * .. * N)
  ans = (n+N-1)! / (N!)
 */
