import java.util.*;

public class Solution
{
	public static void main(String[] args) {
		Solution sol = new Solution();
		String input = "I speak Goat Latin";
		String output = sol.toGoatLatin(input);
		System.out.println(output);
	}

	public String toGoatLatin(String S) {
		if (S == null || S.length() == 0) {
			return S;
		}

		String[] words = S.split(" ");
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < words.length; i++) {
			if (!isVowel(words[i].charAt(0))) {
				if (words[i].length() > 1) {
					sb.append(words[i].substring(1));
					sb.append(words[i].charAt(0));
				} else {
					sb.append(words[i]);
				}
			} else {
				sb.append(words[i]);
			}

			sb.append("ma");
			for (int j = 0; j <= i; j++) {
				sb.append("a");
			}

			sb.append(" ");
		}

		return sb.toString().trim();
	}

	static HashSet<Character> Vowels = new HashSet<>();
	static {
		Vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

	}

	boolean isVowel(char c) {
		return Vowels.contains(c);
	}
}
