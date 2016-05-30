import java.util.*;
import java.math.*;

public class IsFibo
{
    public static void fiboCheck(long n)
    {
	if (n == 0 || n == 1) {
	    System.out.println("IsFibo");
	    return;
	}
	    
	BigInteger fib0 = new BigInteger("0");
	BigInteger fib1 = new BigInteger("1");
	BigInteger nb = new BigInteger(Long.toString(n));
	BigInteger fib = new BigInteger("1");

	while (fib.compareTo(nb) <= 0) {
	    fib = fib0.add(fib1);
	    if (fib.compareTo(nb) == 0) {
		System.out.println("IsFibo");
		return;
	    }
	    fib0 = fib1;
	    fib1 = fib;
	}

	System.out.println("IsNotFibo");
    }

    public static void main(String[] args)
    {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	ArrayList<Long> results = new ArrayList<>();

	for (int i = 0; i < T; i++) {
	    long N = sc.nextLong();
	    results.add(N);
	}

	for (long r : results) {
	    fiboCheck(r);
	}
    }
}
