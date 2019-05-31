import java.util.*;

/*
  Write an algorithm which computes the number of trailing zeros in n factorial.
 */
public class FactorialZeros
{
    static int numberOfZeroFact(int n)
    {
        int count5 = 0;
        int count2 = 0;

        for (int j = n; j >= 5; j--) {
            if (j % 5 == 0) {
                int k = j;
                while (k % 5 == 0) {
                    count5++;
                    k/=5;
                }
            }

            if (j % 2 == 0) {
                int k = j;
                while (k % 2 == 0) {
                    count2++;
                    k/=2;
                }
            }
        }

        System.out.println("5: " + count5);
        System.out.println("2: " + count2);

        return count2 >= count5 ? count5 : count2;
    }

    public static void main(String[] args)
    {
        System.out.println(numberOfZeroFact(200));
    }

}

/*
zero can happen if a number has 5 and even, and 10, so count all numbers that are divisible by 10, count all numbers that are divisible by 5, but numbers that are divisible by 2, return number of 10 that is 5 that has an even multiplier of 2

fact(11) = 11 * 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1 = 10 = 1, 5 = 1, 8 = 2 ^ 3, so number of 0 = 2
Math.log(x) / Math.log(2) gives value in base 2 for number of power of 2
 */
