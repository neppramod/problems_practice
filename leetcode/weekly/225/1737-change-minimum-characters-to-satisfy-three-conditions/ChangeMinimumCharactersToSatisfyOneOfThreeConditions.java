import java.util.*;

public class ChangeMinimumCharactersToSatisfyOneOfThreeConditions {
    public static void main(String[] args) {
	    ChangeMinimumCharactersToSatisfyOneOfThreeConditions sol = new ChangeMinimumCharactersToSatisfyOneOfThreeConditions();
		
	}

	public int minCharacters(String a, String b) {
		return Math.min(Math.min(operation1(a, b), operation1(b, a)), operation2(a, b));
    }
	
    // Operations to make a below b
	// find all counts of when a is greater than b
	// and when b is smaller than a
	// that is how many operations we need
	public int operation1(String a, String b) {

		int result = Integer.MAX_VALUE;

		// start from b
		for (int i = 1; i < 26; i++) {

			// reset count for next iteration
			int count = 0;
			
			for (char c : a.toCharArray()) {
				if ((c-'a') >= i) {  // letter in a is bigger than current character i
					count++;
				}
			}

			for (char c : b.toCharArray()) {
				if ((c - 'a') < i) {  // letter in b is strictly smaller than current character i
					count++;
				}
			}

			// in each operation, we try to minimize result
			// ie, minimize the time when letter in a is bigger than current character i and b is smaller
			// over all characters b to z
			// which ever gives us the least count, we use that as our dividing point
			// so that we would only need to perform that many operations to meet condition 1
			result = Math.min(result, count);
		}

		return result;
	}

	// how many operations do we need to make a and b same character
	// we count the highest frequency across a and b and subtract it from total length
	// what it means is, we need at min, the number of changing the highest frequency element from total
	// e.g. if a = "aaa", and b = "aaa", we only need 6 - 6 = 0 operations
	// e.g. if a = "aaa", and b = "bbb", we need 6 - 3 = 3
	// e.g if a = "aaa" and b = "bcb", we need 6- 3 = 3
	// e.g if a = "abc", and b = "bcb", we need 6 - 3, change 2 in a and 1 in b
	public int operation2(String a, String b) {
		int[] freq = new int[26];

		for (char c : a.toCharArray()) {
			freq[c-'a']++;
		}

		for (char c : b.toCharArray()) {
			freq[c-'a']++;
		}

		int res = 0;
		for (int i = 0; i < 26; i++) {
			res = Math.max(res, freq[i]);
		}

		return a.length() + b.length() - res;
	}
}
