import java.util.*;

public class SubStringWithConcatenationOfWords {
    public static void main(String[] args) {
	    SubStringWithConcatenationOfWords sol = new SubStringWithConcatenationOfWords();
		String s = "wordgoodgoodgoodbestword";
		String[] words = {"word","good","best","good"};
		List<Integer> res = sol.findSubstring(s, words);
		System.out.println(res);
	}

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> resultList = new ArrayList<>();
		
		if (s == null || words == null || s.length() == 0 || words.length == 0) {
			return resultList;
		}

		// Since length of each words is same, we can use length of first word
		int len = words[0].length();
		int n = s.length();
		int m = words.length;


		Map<String, Integer> freqMap = new HashMap<>();
		for (String word: words) {
			freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
		}
		
		for (int i = 0; i <= n - m * len; i++) {
			int j = 0;
			Map<String, Integer> seenFreq = new HashMap<>();

			while (j < m) {
				String word = s.substring(i + j * len, i + (j + 1) * len);

				if (freqMap.containsKey(word)) {
					seenFreq.put(word, seenFreq.getOrDefault(word, 0) + 1);

					if (seenFreq.get(word) > freqMap.get(word)) {
						break;
					}
				} else {
					break;
				}

				j++;
			}

			if (j == m) {
				resultList.add(i);
			}
		}

		return resultList;
	}
}
