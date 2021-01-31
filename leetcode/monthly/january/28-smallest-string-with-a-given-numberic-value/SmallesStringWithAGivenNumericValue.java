import java.util.*;

public class SmallesStringWithAGivenNumericValue {
    public static void main(String[] args) {
	    SmallesStringWithAGivenNumericValue sol = new SmallesStringWithAGivenNumericValue();

		int n = 5;
		int k = 73;

		String result = sol.getSmallestString(n, k);
		System.out.println(result);
	}

	public String getSmallestString(int n, int k) {
		if (n == 0 || k == 0) {
			return "";
		}
		
        char[] cur = new char[n];
		Arrays.fill(cur, 'a');
		k = k-n;

		for (int i = n - 1; i >= 0; i--) {
			if (k > 0) {
				if (k > 25) {
					cur[i] += 25;
					k -= 25;
				} else {
					cur[i] += k;
					k -= k;
				}
			}
		}

		//	System.out.println(cur);
		return new String(cur);
    }
    
}
