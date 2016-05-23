package dp;

import java.math.BigInteger;

public class FibonaciiDynamic {
    public static void main(String[] args) {
        System.out.println(fib(99999));
    }

    static BigInteger fib(int n) {
        if (n < 0 || n > 100000) {
            throw new RuntimeException("n should between 0 and 99");
        }

        BigInteger[] fib = new BigInteger[n+1];
        fib[0] = BigInteger.valueOf(0L);
        fib[1] = BigInteger.valueOf(1L);

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i-1].add(fib[i-2]);
        }

        return fib[n];
    }
}
