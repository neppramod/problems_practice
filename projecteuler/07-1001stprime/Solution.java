import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        setup();
        count(primes);
        //System.out.println(count);

    }
    static final int MAX = 200000;
    static boolean[] primes = new boolean[MAX];

    static void setup()
    {
        Arrays.fill(primes, true);

        for (int i = 2; i < MAX; i++) {
            if (primes[i]) {
                for (int j = i + i; j < MAX; j += i) {
                    primes[j] = false;
                }
            }
        }
    }

    static void count(boolean[] primes) {
        int sum = 0;
        for (int i = 2; i < MAX; i++) {
            if (primes[i]) {
                sum++;
                if (sum == 10001) {
                    System.out.println(i);
                }
            }
        }

        //return sum;
    }

}
