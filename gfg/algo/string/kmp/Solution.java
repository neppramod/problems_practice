import java.util.*;

public class Solution
{
	
	/*
	  KMP: Unlike Naive algorithm, where we slide the pattern by one and compare all characters at each shift, we use a value from lps[] to decide the next characters to be matched. The idea is to not match a character that we know will anyway match.
	 */


	void kmpSearch(String pat, String txt) {
		if (pat == null || txt == null) {
			return;
		}
		
		int M = pat.length();
		int N = txt.length();

		int[] lps = new int[M];
		computeLPSArray(pat, M, lps);
		
		int j = 0;  // index of pat[]
		int i = 0;

		while (i < N) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}

			if (j == M) {
				System.out.println("Pattern found at: " + (i-j));
				j = lps[j - 1];
			} else if (i < N && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
	}

	public static void main(String[] argss) {
		String txt = "AAAAABAAABA";
		String pat = "AAAA";
		Solution sol = new Solution();
		sol.kmpSearch(pat, txt);
	}	
	
	void computeLPSArray(String pat, int M, int[] lps) {
		// length of the previous longest prefix suffix
		int len = 0;
		int i = 1;
		lps[0] = 0;  // lps[0] is always 0

		// the loop calculates lps[i] for i = 1 to M-1
		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {  // pat[i] != pat[len]

				// This is tricky. Consider the example.
				// AAACAAAA and i = 7. The idea is similar to search step.
				if (len != 0) {
					len = lps[len - 1];

					// also note that we do not increment i here
				} else {  // if len = 0
					lps[i] = len;
					i++;
				}
			}
		}
	}
}
