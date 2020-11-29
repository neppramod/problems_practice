import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int K = 9;
		int result = sol.smallestRepunitDivByK(K);
		System.out.println(result);
	}
	
    public int smallestRepunitDivByK(int K) {
		int remainder = 0;
		if (K == 2 || K == 5) {
			return -1;
		}

		for (int i = 0; i < K; i++) {
			remainder = (remainder * 10 + 1) % K;

			if (remainder == 0) {
				return i + 1;
			}
		}
		
		return -1;
    }
}
