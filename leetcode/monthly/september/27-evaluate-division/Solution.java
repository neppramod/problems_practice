import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
		List<List<String>> queries = Arrays.asList(Arrays.asList("a", "c"),
												   Arrays.asList("b", "c"),
												   Arrays.asList("a", "e"),
												   Arrays.asList("a", "a"),
												   Arrays.asList("x", "x"));
		double[] values = { 2.0, 3.0 };

		double[] result = sol.calcEquation(equations, values, queries);
		System.out.println(Arrays.toString(result));
    }
    
    /*
	equations = [ ["a", "b"], ["b", "c"] ],
	values = [2.0, 3.0],
	queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
	
	
	root[a : b, b : b, c : c]	
	rate[a : 2.0, b: 3.0, c: 1.0]	
	 */

	HashMap<String, String> root = new HashMap<>();
	HashMap<String, Double> rate = new HashMap<>();

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int n = equations.size();

		for (int i = 0; i < n; i++) {
			String x = equations.get(i).get(0);
			String y = equations.get(i).get(1);

			root.put(x, x);
			root.put(y, y);
			rate.put(x, 1.0);
			rate.put(y, 1.0);
		}

		for (int i = 0; i < n; i++) {
			String x = equations.get(i).get(0);
			String y = equations.get(i).get(1);

			union(x, y, values[i]);
		}


		double[] result = new double[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			String x = queries.get(i).get(0);
			String y = queries.get(i).get(1);

			if (!root.containsKey(x) || !root.containsKey(y)) {
				result[i] = -1.0;
				continue;
			}

			String rootx = findRoot(x, x, 1.0);
			String rooty = findRoot(y, y, 1.0);
			result[i] = rootx.equals(rooty) ? rate.get(x) / rate.get(y) : -1.0;
		}

		for (String k : root.keySet()) {
			System.out.print(k + " : " + root.get(k));
			System.out.println(" : " + rate.get(k));
		}

		return result;
    }

	void union(String x, String y, double value) {
		String rootx = findRoot(x, x, 1.0);
		String rooty = findRoot(y, y, 1.0);
		root.put(rootx, rooty);
		double r1 = rate.get(x);
		double r2 = rate.get(y);
		rate.put(rootx, value * r2 / r1);
	}

	String findRoot(String originalX, String X, double r) {
		if (root.get(X).equals(X)) {
			root.put(originalX, X);
			rate.put(originalX, r * rate.get(X));
			return X;
		}

		return findRoot(originalX, root.get(X), r * rate.get(X));
	}
}
