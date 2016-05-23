package euler;

import java.util.Arrays;
import java.util.stream.*;

public class E001FibonaciiEven {
    public static long fib(long n) {
        return n == 1 || n == 2 ? n : fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        //System.out.println(fib(47));
        //System.out.println(LongStream.range(0, 47).parallel().filter(x -> fib(x) < 4000000000L && fib(x)
        //        % 2 == 0).reduce(0, (a, b) -> fib(a) + fib(b)));
        /*
        long sum = 0;
        for (int i = 0; i < 47; i++) {
            long x = fib(i);
            if (x < 4000000000L && x % 2 == 0) {
                sum += x;
            }
        }

        System.out.println(sum);
        */

        long sum = 0;
        for (int i = 3; i < 47; i++) {
            long x = fib(i);
            sum += x % 2 == 0 ? x : 0;
        }
        System.out.println(sum);
    }
}
