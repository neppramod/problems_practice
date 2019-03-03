 import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = getMinSquares(N);
        System.out.println(result);
    }

    static int getMinSquares(int n)
    {
        int result = 0;

        while (n > 0) {
            int curSqr = (int)Math.sqrt(n);
            curSqr = curSqr * curSqr;

            result += n/curSqr;
            n = n % curSqr;

            if (n <= 3) {
                result += n;
                break;
            }
        }

        return result;
    }
}
