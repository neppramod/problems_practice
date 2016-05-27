import java.math.*;
import java.util.*;

public class FibFindingEasy
{
	public static BigInteger fib(long N, long A, long B)
	{
		if (N == 0) return BigInteger.valueOf(A);
		if (N == 1) return BigInteger.valueOf(B);

		BigInteger fib0 = BigInteger.valueOf(A);
		BigInteger fib1 = BigInteger.valueOf(B);
		BigInteger fib = new BigInteger("0");

		for (long i = 2L; i < N + 1; i++) {
			fib = fib1.add(fib0);
			fib0 = fib1;
			fib1 = fib;
		}

		return fib;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		ArrayList<BigInteger> results = new ArrayList<>();

		for (int i = 0; i < T; i++) {
			long A = sc.nextLong();
			long B = sc.nextLong();
			long N = sc.nextLong();
			results.add(fib(N, A, B));
		}

		for (BigInteger bi : results) {
			System.out.println(bi.toString());
		}
	}
}
