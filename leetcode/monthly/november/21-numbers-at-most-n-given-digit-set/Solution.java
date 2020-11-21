import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		
	}
	
    public int atMostNGivenDigitSet(String[] digits, int n) {
		String strOfN = n + "";
		int nLength = strOfN.length();

		int numberOfDigits = digits.length;

		int result = 0;

		// calculate for all numbers less than nLength
		// as all digits can be used to form those numbers
		for (int i = 1; i < nLength; i++) {
			result += Math.pow(numberOfDigits, i);
		}

		// now for the length of n
		for (int i = 0; i < nLength; i++) {
			boolean hasSameNo = false;  // if first digit is same as first digit of n

			for (String digit : digits) {
				if (digit.charAt(0) < strOfN.charAt(i)) {

					// if digit characters are less than that of target
					// we can easily use them
					result += Math.pow(numberOfDigits, nLength - i - 1);
				} else if (digit.charAt(0) == strOfN.charAt(i)) {
					hasSameNo = true;  // since characters match, move ahead

					if (i == nLength - 1) {
						result++;  // if end increase total, else just mark it
					}
				}
			}

			if (!hasSameNo) {  // if characters don't match that means digit.charAt(0) > n digit at i, we can return the result
				return result;
			}

		}

		return result;
    }
}
