import java.util.*;

public class WordBreak
{

    static final int ALPHABET_SIZE = 26;

    private static class Trie
    {
        Trie[] child = new Trie[ALPHABET_SIZE];
        boolean isEndOfWord = false;
    }

    // insert key into trie, if prefix mark end of key as leaf
    private static void insert(Trie root, String key)
    {
        Trie cur = root;
        for (int i = 0; i < key.length(); i++) {

            int index = key.charAt(i) - 'a';
            if (cur.child[index] == null) {
                cur.child[index] = new Trie();
            }

            cur = cur.child[index];
        }

        // mark cur as leaf
        cur.isEndOfWord = true;
    }

    // returns true if key is present in trie
    private static boolean search(Trie root, String key)
    {
        Trie cur = root;
        for (int i = 0; i < key.length(); i++) {

            int index = key.charAt(i) - 'a';
            if (cur.child[index] == null) {
                return false;
            }

            cur = cur.child[index];

        }

        // check if it is leaf
        return (cur != null && cur.isEndOfWord);
    }

    // returns true, if string can be segmented into space separated words, otherwise returns false
    static boolean wordBreak(Trie root, String str)
    {
        int size = str.length();

        // Base case
        if (size == 0) {
            return true;
        }

        for (int i = 0; i <= size; i++) {
            if (search(root, str.substring(0, i)) && wordBreak(root, str.substring(i))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        String dictionary[] = {"mobile","samsung","sam",
                               "sung","man","mango",
                               "icecream","and","go","i",
                               "like","ice","cream"};

        // construct trie
        Trie root = new Trie();
        for (int i = 0; i < dictionary.length; i++) {
            insert(root, dictionary[i]);
        }

        System.out.println(wordBreak(root, "ilikesamsung"));
        System.out.println(wordBreak(root, "iiiiiiii"));
        System.out.println(wordBreak(root, ""));
        System.out.println(wordBreak(root, "ilikelikeimangoiii"));
        System.out.println(wordBreak(root, "samsungandmango"));
        System.out.println(wordBreak(root, "samsungandmangok"));
    }
}
