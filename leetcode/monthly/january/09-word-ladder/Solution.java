import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		int result = sol.ladderLength(beginWord, endWord, wordList);
		System.out.println(result);
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Set<String> wordDict =  new HashSet<>(wordList);
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();

		queue.add(beginWord);  // add the start word
		visited.add(beginWord);

		int level = 0;  // current transformation

		while (!queue.isEmpty()) {
			int size = queue.size();
			level++;

			// do a level order traversal with each level
			// since we want to go to each level only once, that's why we have to loop all other nodes on same level before adding
			// to level
			while (size-- > 0) {
				String cur = queue.poll();

				if (cur.equals(endWord)) {
					return level;  // if we reached end before others, return
				} else {
					for (int i = 0; i < cur.length(); i++) {
						for (char j = 'a'; j <= 'z'; j++) {
							String newWord = cur.substring(0, i) + j + cur.substring(i+1);

							if (wordDict.contains(newWord) && !visited.contains(newWord)) {
								queue.add(newWord);
								visited.add(newWord);
							}
						}
					}
				}

				
			}
		}

		return 0;
	}
	
   
}
