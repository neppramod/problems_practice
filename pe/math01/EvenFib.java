import java.util.*;
import java.math.*;

public class EvenFib
{
    public static void findEvenFib()
    {
	    
	BigInteger fib0 = new BigInteger("0");
	BigInteger fib1 = new BigInteger("1");
	BigInteger nb = new BigInteger(Long.toString(4000000L));
	BigInteger fib = new BigInteger("1");
	BigInteger sum = new BigInteger("0");
	BigInteger even = new BigInteger("2");
	BigInteger zero = new BigInteger("0");

	while (fib.compareTo(nb) <= 0) {
	    fib = fib0.add(fib1);

	    if (fib.mod(even).compareTo(zero) == 0) {
		sum = sum.add(fib);
	    }
	    
	    fib0 = fib1;
	    fib1 = fib;
	}

	System.out.println(sum.toString());
    }

    public static void main(String[] args)
    {
	findEvenFib();
    }
}
