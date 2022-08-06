import java.util.*;

/*
Given a set of characters and a positive integer k, print all possible strings of length k that can be formed from the given set.

E.g. If set = {'a', 'b'}, and k = 2
we need to print aa, ab, ba, bb and so on

We can start with a blank string, and if this string's size is k, we can print it
otherwise we loop through the set and add each character to this blank string and recurse

 */
public class PrintAllStringsOfLengthKFromNChars {

	public static void main(String[] args) {
		PrintAllStringsOfLengthKFromNChars sol = new PrintAllStringsOfLengthKFromNChars();
		int k = 3;
		sol.printAllStringsOfKLength(k);
	}

	char[] set = { 'a', 'b' };

	public void printAllStringsOfKLength(int k) {
		printAllStringsOfKLength(k, "");
	}

	private void printAllStringsOfKLength(int k, String s) {
		if (s.length() == k) {
			System.out.println(s);
		} else {
			for (char c : set) {
				printAllStringsOfKLength(k, s + c);
			}
		}
	}
}
