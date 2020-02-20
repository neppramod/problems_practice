import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        setup();
        System.out.println("Setup");
        long result = summationPrime(2000000);
        System.out.println(result);

    }
    static int MAX = 2000010;
    static boolean[] primes = new boolean[MAX];

    static void setup()
    {
        Arrays.fill(primes, true);

        for (int i = 2; i * i < MAX; i++) {
            if (primes[i]) {

                for (int j = i * i; j < MAX && j > 0; j+=i) {
                    primes[j] = false;
                }
            }
        }
    }

    static long summationPrime(int limit)
    {
        long sum = 0;
        for (int i = 2; i < limit; i++) {
            if (primes[i]) {
                sum += i;
            }
        }

        return sum;
    }
}
