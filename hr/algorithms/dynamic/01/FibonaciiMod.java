import java.util.*;
import java.math.*;

public class FibonaciiMod
{
    static BigInteger fib(int a1, int b1, int n)
    {
        BigInteger a = BigInteger.valueOf((long)a1);
        BigInteger b = BigInteger.valueOf((long)b1);
        BigInteger c = BigInteger.valueOf((long)0);
        
        for (int i = 3; i <= n; i++) {
            c = b.multiply(b).add(a);
            a = b;
            b = c;
        }

        return c;        
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(fib(a,b,n));
    }
}
