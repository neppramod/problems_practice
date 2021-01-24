import java.util.*;

public class TwoKnights {
    public static void main(String[] args) {
	    TwoKnights sol = new TwoKnights();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		for (int k = 1; k <= n; k++) {
			sb.append(sol.twoKnightsAttack(k) + "\n");
		}

		System.out.println(sb);
	}
	
    public long twoKnightsAttack(int k) {
		if (k == 1) {
			return 0;
		} else {
			
			long x = k * k;

			// First knight can be placed in k^2 places in kxk board
			// Second knight can be placed in 1 less spot
			// Since both knights are of same type
			// from identity permutation divide by 2
			// Now to subtract all the place they could attack each other
			// Find all the 2x3 and 3x2 blocks in kxk board
			// in 3x3 board you have 2 2x3 boards horizontally
			// and you can move that board down 1 time (k-2)
			// you can do same thing with 3x2 board also (but alternatively)
			// move right k-2, but move down k-1
			// effectively 2 * (k-1) * (k-2)
			// also in a 2x3 block you can attack alternative corner
			// e.g top left to bottom right
			// and top right to bottom left
			// so we double the result
			// ie. 4 * (k-1) * (k-2)
			return (x * (x-1)/2) - 4 * (k-1)*(k-2);
		}
	}
}
