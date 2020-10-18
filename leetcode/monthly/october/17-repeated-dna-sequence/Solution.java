import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();

		String s = "AAAAAAAAAAAAA";
		List<String> result = sol.findRepeatedDnaSequences(s);
		System.out.println(result);
    }

	public List<String> findRepeatedDnaSequences(String s) {

		if (s == null || s.length() == 0) {
			return new ArrayList<String>();
		}
		
		Set<String> set = new HashSet<>();
		Set<String> repeated = new HashSet<>();
		for (int i = 0; i < s.length() - 9; i++) {
			String cur = s.substring(i, i + 10);
			if (set.contains(cur)) {
				repeated.add(cur);
			}

			set.add(cur);
		}

		return new ArrayList<String>(repeated);
	}

	// TLE for 1/31
	/*
    public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<>();

		if (s == null || s.length() == 0) {
			return result;
		}

		Set<String> alreadyUsed = new HashSet<>();

		for (int i = 0; i < s.length() - 10; i++) {
			String pat = s.substring(i, i + 10);
			
			if (!alreadyUsed.contains(pat)) {
				alreadyUsed.add(pat);
				
				List<Integer> foundKmp = kmpSearch(pat, s.substring(i));
				if (foundKmp.size() > 1) {
					result.add(pat);
				}
			}
		}

		return result;
    }

	List<Integer> kmpSearch(String pat, String txt) {
		List<Integer> result = new ArrayList<>();
		
		if (pat == null || txt == null) {
			return result;
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
				result.add(i - j);
				
				j = lps[j - 1];
			} else if (i < N && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}

		return result;
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
	*/
}
