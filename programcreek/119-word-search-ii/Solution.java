import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		String[] words = {"oath", "pea", "eat", "rain"};
		char[][] board = {{'o', 'a', 'a', 'n'},
						  {'e', 't', 'a', 'e'},
						  {'i', 'h', 'k', 'r'},
						  {'i', 'f', 'l', 'v'},
		};

		List<String> result = sol.wordSearch(board, words);
		System.out.println(result);
    }

	List<String> wordSearch(char[][] board, String[] words) {
		if (board == null || board.length == 0 || board[0].length == 0 || words == null) {
			return new ArrayList<String>();
		}

		HashSet<String> set = new HashSet<>();
		int m = board.length;
		int n = board[0].length;

		Trie root = new Trie();
		for (String word : words) {
			insert(word, root);
		}

		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, visited, set, i, j, "", root);
			}
		}

		return new ArrayList<String>(set);
	}

	void dfs(char[][] board, boolean[][] visited, HashSet<String> set, int i, int j, String str, Trie trie) {
		int m = board.length;
		int n = board[0].length;

		if (i < 0 || i >= m || j < 0 || j >= n) {
			return;
		}

		if (visited[i][j]) {
			return;
		}

		str = str + board[i][j];
		if (!prefixExist(str, trie)) {
			return;
		}

		if (search(str, trie)) {
			set.add(str);
		}

		visited[i][j] = true;
		dfs(board, visited, set, i + 1, j, str, trie);
		dfs(board, visited, set, i - 1, j, str, trie);
		dfs(board, visited, set, i, j - 1, str, trie);
		dfs(board, visited, set, i, j + 1, str, trie);
		visited[i][j] = false;
	}

	static class Trie {
		Trie[] child = new Trie[26];
		String value = "";
	}

	static void insert(String word, Trie root) {
		Trie cur = root;
		
		for (int i = 0; i < word.length(); i++) {
			int cI = word.charAt(i) - 'a';

			if (cur.child[cI] == null) {
				cur.child[cI] = new Trie();
			}

			cur = cur.child[cI];
		}
		cur.value = word;
	}

	static boolean search(String word, Trie root) {
		Trie cur = root;
		
		for (int i = 0; i < word.length(); i++) {
			int cI = word.charAt(i) - 'a';

			if (cur.child[cI] == null) {
				return false;
			}

			cur = cur.child[cI];
		}
		return cur.value.equals(word);
	}

	static boolean prefixExist(String prefix, Trie root) {
		Trie cur = root;
		
		for (int i = 0; i < prefix.length(); i++) {
			int cI = prefix.charAt(i) - 'a';

			if (cur.child[cI] == null) {
				return false;
			}

			cur = cur.child[cI];
		}

		return true;
	}
    
}
