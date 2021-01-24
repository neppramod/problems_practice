import java.util.*;

public class WeirdAlgorithm {
    public static void main(String[] args) {
	    WeirdAlgorithm sol = new WeirdAlgorithm();
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		sol.printWeirdAlgorithm(n);
	}

	public void printWeirdAlgorithm(long n) {
		while (n != 1) {
			System.out.print(n + " ");
			if (n % 2 == 0) {
				n = n/2;
			} else {
				n = n * 3 + 1;
			}
		}

		System.out.println(n);
	}
    
}
