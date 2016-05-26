import java.math.*;
import java.util.*;

public class Fib
{
    public static BigInteger fib(int n)
    {
	return fib(n, new BigInteger[n + 1]);
    }

    private static BigInteger fib(int n, BigInteger[] memo)
    {

	BigInteger bi;
	if (n == 0 || n == 1) {
	    bi =  new BigInteger(""+n);
	    return bi;
	}

	if (memo[n] == null) {
	    memo[n] = fib(n-1, memo).add(fib(n-2, memo));
	}

	return memo[n];
    }

    public static void main(String[] args)
    {
	Scanner sc = new Scanner(System.in);
	System.out.print("Fib: ");
	int N = sc.nextInt();
	System.out.println(fib(N).toString());
    }
}
