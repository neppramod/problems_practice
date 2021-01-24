import java.util.*;

public class TwoSets {
    public static void main(String[] args) {
	    TwoSets sol = new TwoSets();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sol.printTwoSets(n);
	}
	
    // Here we don't need to do the dp subset sum approach
	// if desired sum is greater than number add it to first set
	// else to second set
	void printTwoSets(int n) {

		// if total sum / 2 is not even
		// we cannot divide 1 to n in two sets
		if ((n * (n + 1)) % 4 != 0) {
			System.out.println("NO");
			return;
		}

		// sum is the desired sum
		long sum = n * (n + 1) / 4;
		List<Integer> firstSet = new ArrayList<>();
		List<Integer> secondSet = new ArrayList<>();

		// if sum >= i, add i to one set, and decrement i from sum
		// else just add i to second set, wait until sum becomes greater than i
		for (int i = n; i >= 1; i--) {
			if (sum >= i) {
				sum -= i;
				firstSet.add(i);
			} else {
				secondSet.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append("YES\n");
		sb.append(firstSet.size() + "\n");
		for (int fs : firstSet) {
			sb.append(fs + " ");
		}
		sb.append("\n");

		sb.append(secondSet.size() + "\n");
		for (int ss : secondSet) {
			sb.append(ss + " ");
		}
		sb.append("\n");

		System.out.println(sb);
	}
}
