import java.util.*;

public class CrackingTheSafe {
    public static void main(String[] args) {
	    CrackingTheSafe sol = new CrackingTheSafe();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		System.out.println(sol.crackSafe(n, k));
	}

	// Related to De Bruijin Sequence
    public String crackSafe(int n, int k) {

		// first as a start we build a n-1 length string consisting of 0s
		// we call dfs with that number
		// in dfs we iterate from 0 to k-1 (as we can use characters from 0 to k-1)
		// and append that character to start string
		// if that string was not seen before, we make it as seen
		// cal dfs recursively with the new string with first character removed
		// once we finish our topological search we append the character k to our answer
		// similarly we add intial string before calling dfs to our result and return

		if (n == 1 && k == 1) {
			return "0";
		}

		Set<String> visited = new HashSet<>();
		StringBuilder result = new StringBuilder();

		StringBuilder start = new StringBuilder();
		for (int i = 0; i < n-1; i++) {
			start.append("0");
		}
		
		dfs(start.toString(), k, visited, result);

		result.append(start.toString());
		return result.toString();
    }

	void dfs(String s, int k, Set<String> visited, StringBuilder result) {
		for (int i = 0; i < k; i++) {
			String cur = s + i;

			if (!visited.contains(cur)) {
				visited.add(cur);
				cur = cur.substring(1);
				dfs(cur, k, visited, result);
				result.append(i);
			}
		}
	}
}
