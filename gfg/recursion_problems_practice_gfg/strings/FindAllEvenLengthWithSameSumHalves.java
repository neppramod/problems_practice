import java.util.*;

/*
Given a number n, find all binary sequences of length 2n such that sum of first n bits is same as sum of last n bits.

  This is similar to PrintAllStringsOfLengthKFromNChars

  We loop through 0 and 1 at each iteration and add it to build the string, once we reach 2 * n, we check
  both halves for same sum
 */

public class FindAllEvenLengthWithSameSumHalves {
    public static void main(String[] args) {
	    FindAllEvenLengthWithSameSumHalves sol = new FindAllEvenLengthWithSameSumHalves();
		int n = 3;
		sol.printEvenLengthSum(n);		
	}

	char[] set = { '0', '1' };
	private void printEvenLengthSum(int n) {
		printEvenLengthSum("", n * 2);
	}

	private void printEvenLengthSum(String s, int n) {
		if (s.length() == n) {
			if (sameHalfSums(s)) {
				System.out.println(s);
			}
		} else {
			for (char c : set) {
				printEvenLengthSum(s + c, n);
			}
		}
	}

	private boolean sameHalfSums(String s) {
		int length = s.length();

		int l = getSum(s, 0, length / 2 - 1);
		int r = getSum(s, length / 2, length - 1);
		return l == r;
	}

	private int getSum(String s, int left, int right) {
		int sum = 0;
		for (int i = left; i <= right; i++) {
			sum += s.charAt(i) - '0';
		}

		return sum;
	}
    
}
