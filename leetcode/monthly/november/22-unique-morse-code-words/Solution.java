import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		String[] words = { "gin", "zen", "gig", "msg" };
		int result = sol.uniqueMorseRepresentations(words);
		System.out.println(result);
	}

	static Map<Character, String> morseMap = new HashMap<>();

	static {

		List<String> list = Arrays.asList(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..");

		for (int i = 0; i < 26; i++) {
			morseMap.put((char)('a' + i), list.get(i));
		}

	}
	
	public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) {
			return 0;
		}


		HashSet<String> set = new HashSet<>();
		for (String word : words) {
			String morseCode = getMorseCode(word);

			if (!set.contains(morseCode)) {
				set.add(morseCode);
			}
		}

		return set.size();
    }

	String getMorseCode (String word) {
		if (word.length() == 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (char c : word.toCharArray()) {
			sb.append(morseMap.get(c));
		}

		return sb.toString();
	}
}
