import java.util.*;
import java.math.*;

public class BitStrings {
    public static void main(String[] args) {
	    BitStrings sol = new BitStrings();
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// Can use BigInteger modPow(exponent, mod) as well
		System.out.println(sol.power(2, n));
	}

	long power(int n, int exponent) {
		if (exponent == 0) {
			return 1;
		}

		long x = power(n, exponent/2) % MOD;

		if (exponent % 2 == 0) {
			return (x * x) % MOD;
		} else {
			return (x * x * n) % MOD;
		}
	}
	
	private static final int MOD = 1000000007;
}
