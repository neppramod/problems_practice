/*
  ["wrt", "wrf", "er", "ett", "rftt"]
  output = "wertf"
  
  Maintain two data structures,
  map of char, set<char>
  map of char, int to count order

  Initially set order map count to 0, for each character, using all characters in all words

  Now, starting iterating through the words list, looking at two adjacent words

  Compare characters of each word and if they don't match, increment order of second character in order map, and second character to set map of first character

  Once the loop finishes the order map and set map should be populated.

  Now we will use topological sorting
  add all characters from order map that have count 0 to the queue. Iterate queue until empty.

  At each iteration add current polled char to result

  Get set of all elements from map, that have key as current element in queue, decrement their order in order map

  If their count becomes 0, add to queue

*/


import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
		String result = sol.alienOrder(words);
		System.out.println(result);
	}
	
	public String alienOrder(String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}

		Map<Character, Set<Character>> map = new HashMap<>();
		Map<Character, Integer> orderMap = new HashMap<>();

		for (String word : words) {
			for (char c: word.toCharArray()) {
				if (!orderMap.containsKey(c)) {
					orderMap.put(c, 0);
				}
			}
		}


		for (int i = 0; i < words.length-1; i++) {
			String current = words[i];
			String next = words[i + 1];

			int length = Math.min(current.length(), next.length());
			for (int j = 0; j < length; j++) {
				char c1 = current.charAt(j);
				char c2 = next.charAt(j);
				
				if (c1 != c2) {
					Set<Character> set = map.get(c1);

					if (set == null) {
						set = new HashSet<>();
					}

					if (!set.contains(c2)) {
						set.add(c2);
						map.put(c1, set);
						orderMap.put(c2, orderMap.get(c2) + 1);
					}
					break;
				}
			}
		}
		// Topological sorting

		Queue<Character> queue = new LinkedList<>();
		for (char k : orderMap.keySet()) {
			if (orderMap.get(k) == 0) {
				queue.add(k);
			}
		}


		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			char c = queue.poll();
			sb.append(c);

			if (map.containsKey(c)) {
				Set<Character> set = map.get(c);

				for (char c2 : set) {
					orderMap.put(c2, orderMap.get(c2) - 1);

					if (orderMap.get(c2) == 0) {
						queue.add(c2);
					}
				}
					
			}
		}

		if (sb.length() != orderMap.size() ) {
			return "";
		}
		
		return sb.toString();
	}
}
