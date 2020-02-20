import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        long result = largestPrimeFactor(600851475143L);

        System.out.println(result);

    }

    static long largestPrimeFactor(long number)
    {
        long i = 3;
        long max = 0;

        while (number % 2 == 0) {
            max = Math.max(max, 2);
            number /= 2;
        }

        while (i <= number) {
            while (number % i == 0) {
                max = Math.max(max, i);
                number /= i;
            }
            i+=2;
        }

        return max;
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
