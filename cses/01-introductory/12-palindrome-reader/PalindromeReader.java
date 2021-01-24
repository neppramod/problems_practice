import java.util.*;

public class PalindromeReader {
    public static void main(String[] args) {
	    PalindromeReader sol = new PalindromeReader();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(sol.palindromeReader(s));
	}
	
    public String palindromeReader(String s) {
		int[] frequency = getFrequency(s);

		if (!isValid(frequency)) {
			return "NO SOLUTION";
		} else {
			// if frequency is odd, put in middle
			// else distribute half to beginning, half to end
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			
			for (int i = 0; i < 26; i++) {
				if (frequency[i] != 0) {
					if (frequency[i] % 2 == 1) { // odd, add to end of sb1
						sb1.append(repeat((char)('A' + i), frequency[i]));
					} else {
						int half = frequency[i] / 2;
						String r = repeat((char) ('A' + i), half);
						sb1.insert(0, r);
						sb2.append(r);
					}
				}
			}

			sb1.append(sb2);
			return sb1.toString();
		}
	}

	String repeat(char c, int times) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < times; i++) {
			sb.append(c);
		}

		return sb.toString();
	}

	private boolean isValid(int[] frequency) {
		int countOdd = 0;
		for (int i = 0; i < 26; i++) {
			if (frequency[i] % 2 == 1) {
				countOdd++;
			}
		}

		return countOdd == 0 || countOdd == 1;
	}

	private int[] getFrequency(String s) {
		int[] freq = new int[26];
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i) - 'A']++;
		}

		return freq;
	}
}
