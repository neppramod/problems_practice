import java.util.*;
 

class WordDictionary {

	public static void main(String[] args) {
		WordDictionary d = new WordDictionary();
		d.addWord("bad");
		d.addWord("dad");
		d.addWord("mad");

		System.out.println(d.search("pad"));
		System.out.println(d.search("bad"));
		System.out.println(d.search(".ad"));
		System.out.println(d.search("b.."));
	}
	Trie root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
			return;
		}

		Trie cur = root;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.child[c-'a'] == null) {
				cur.child[c - 'a'] = new Trie();
			}
			cur = cur.child[c - 'a'];
		}
		cur.leaf = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
		return search(root, word, 0);
    }

	boolean search(Trie node, String word, int start) {
		if (node.leaf && start == word.length()) {
			return true;
		}

		if (start >= word.length()) {
			return false;
		}

		char c = word.charAt(start);

		if (c == '.') {
			boolean found = false;
			for (int i = 0; i < 26; i++) {
				if (node.child[i] != null) {
					if (search(node.child[i], word, start + 1)) {
						found = true;
						break;
					}
				}
			}

			if (found) {
				return true;
			}
		} else {
			int ind = c - 'a';
			if (node.child[ind] != null) {
				return search(node.child[ind], word, start + 1);
			} else {
				return false;
			}
		}

		return false;
	}
	
	static class Trie
	{
		Trie[] child = new Trie[26];
		boolean leaf = false;
	}
}

