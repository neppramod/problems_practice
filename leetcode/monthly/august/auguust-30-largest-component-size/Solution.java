import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] A = {4, 6, 15, 35};
		int res = sol.largestComponentSize(A);
		System.out.println(res);
    }

	public int largestComponentSize(int[] A) {
		Map<Integer, Integer> p = new HashMap<>();

		for (int a : A) {
			for (int f = 2; f * f <= a; f++) {
				if (a % f == 0) {
					union(a, f, p);
					union(a, a / f, p);
				}
			}
		}

		int result = 1;
		Map<Integer, Integer> freq = new HashMap<>();

		for (int a : A) {
			int fN = find(a, p);

			freq.put(fN, freq.getOrDefault(fN, 0) + 1);
			result = Math.max(result, freq.get(fN));
		}

		return result;
	}
    
	public int find(int x, Map<Integer, Integer> p) {
		if (p.get(x) == null) {
			p.put(x, x);
		}

		while (x != p.get(x)) {
			x = p.get(x);
		}

		return x;
	}

	public void union(int x, int y, Map<Integer, Integer> p) {
		int fx = find(x, p);
		int fy = find(y, p);

		if (fx > fy) {
			p.put(fx, fy);
		} else {
			p.put(fy, fx);
		}
	}
}
