package dp;

import java.math.BigInteger;

public class FibonaciiRecursive {
    private static BigInteger fib(int n) {
        return n < 3 ? BigInteger.valueOf(1L) : fib (n-1).add(fib(n - 2));
    }

    public static void main(String[] args) {
        System.out.println(fib(40));
    }
}
