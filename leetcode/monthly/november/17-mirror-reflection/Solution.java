import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int p = 2;
		int q = 1;

		int result = sol.mirrorReflection(p, q);
		System.out.println(result);
	}
	

	public int mirrorReflection(int p, int q) {
		int g = gcd(p, q);

		p /= g;
		p %= 2;
		q /= g;
		q %= 2;

		if (p  == 1 && q == 1) {
			return 1;
		} else if (p  == 1) {
			return 0;
		} else {
			return 2;
		}
    }

	int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
