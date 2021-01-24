import java.util.*;

public class TrailingZeros {
    public static void main(String[] args) {
	    TrailingZeros sol = new TrailingZeros();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(sol.trailingZeros(n));
	}
	
    // factorial 20 has 4 trailing 0s
	// divide n by 5, ie. 20/5 = 4
	// next divide n by 5 * 5 as long as it is less or equal to n
	// e.g factorial 25 has 6 0s
	// divide 25 / 5 = 5
	// next 5 * 5 = 25, 25/25 = 1
	// therefore 5 + 1 = 6

	public int trailingZeros(int n) {
		int zeros = 0;
		for (int i = 5; i <= n; i*=5) {
			zeros += (n/i);
		}

		return zeros;
	}
}
