import java.util.*;

// Use arithmetic series summation

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = triangleNumberWithOverFiveHundredDivisors();
        System.out.println(num);

        //System.out.println(divisors(28));

        /*

Lot of calculation
          2162160 - 320
          10767120 - 320
          13857480 - 320
          17907120 - 480
          20991960 - 320
          22582560 - 384
          27561600 - 384
          29610360 - 320
          30728880 - 360
          31240560 - 320
          34283340 - 324
          37191000 - 384
          39209940 - 384
          43809480 - 384
          45158256 - 320
          48024900 - 405
          48565440 - 448
          53411280 - 320
          54752880 - 320
          59192640 - 448
          60769800 - 432
          60935280 - 320
          64292130 - 320
          64701000 - 384
          65431080 - 384
          69390090 - 384
          73150560 - 384
          73926720 - 336
          75897360 - 360
          76576500 - 576
          576
          12375

         */
    }

    static int triangleNumberWithOverFiveHundredDivisors()
    {
        for (int i = 1; i <= 50000; i++) {
            int cur = i * (i + 1) / 2;

            int divisors = divisors(cur);

            if (divisors > 300) {
                System.out.println(cur + " - " + divisors);
            }


            if (divisors > 500) {
                System.out.println(divisors);
                return i;
            }
        }

        return 0;
    }

    static int divisors(int number)
    {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count;
    }
}
