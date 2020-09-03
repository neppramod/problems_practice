import java.util.*;

public class StreamChecker
{
	public static void main(String[] args) {
		StreamChecker streamChecker = new StreamChecker(new String[] {"cd","f","kl"});
		System.out.println(streamChecker.query('a'));          // return false
		System.out.println(streamChecker.query('b'));          // return false
		System.out.println(streamChecker.query('c'));          // return false
		System.out.println(streamChecker.query('d'));          // return true, because 'cd' is in the wordlist
		System.out.println(streamChecker.query('e'));          // return false
		System.out.println(streamChecker.query('f'));          // return true, because 'f' is in the wordlist
		System.out.println(streamChecker.query('g'));          // return false
		System.out.println(streamChecker.query('h'));          // return false
		System.out.println(streamChecker.query('i'));          // return false
		System.out.println(streamChecker.query('j'));          // return false
		System.out.println(streamChecker.query('k'));          // return false
		System.out.println(streamChecker.query('l'));          // return true, because 'kl' is in the wordlist

	}


	Trie root = new Trie();
	StringBuilder sb = new StringBuilder();

	public StreamChecker(String[] words) {
		if (words == null || words.length == 0) {
			return;
		}

		for (String word : words) {
			insert(word);
		}

	}

	void insert(String word) {
			if (word == null || word.length() == 0) {
				return;
			}

		Trie node = root;
			for (int i = word.length()-1; i >= 0; i--) {
				char c = word.charAt(i);

				if (node.child[c - 'a'] == null) {
					node.child[c - 'a'] = new Trie();
				}
				node = node.child[c - 'a'];
			}

			node.leaf = true;
	}



	public boolean query(char letter) {

		sb.append(letter);
		Trie node = root;

		for (int i = sb.length() - 1; i >= 0; i--) {
			char c = sb.charAt(i);

			if (node.child[c-'a'] == null) {
				return false;
			}

			node = node.child[c - 'a'];

			if (node.leaf) {
				return true;
			}
		}

		return false;

	}


	static class Trie
	{
		boolean leaf = false;
		Trie[] child = new Trie[26];
	}

}
