import java.util.*;

public class AutoComplete
{
    private static final int ALPHABET_SIZE = 26;

    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isWordEnd = false;
    }

    // If not present, inserts key into trie. If the key is prefix of trie node, marks leaf node
    static void insert(TrieNode root, String key)
    {
        TrieNode pCrawl = root;

        for (int level = 0; level < key.length(); level++) {

            int index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
            }

            pCrawl = pCrawl.children[index];
        }

        // Mark last node as leaf
        pCrawl.isWordEnd = true;
    }

    // Returns true if key is present in trie, else returns false
    static boolean search(TrieNode root, String key)
    {
        int length = key.length();
        TrieNode pCrawl = root;


        for (int level = 0; level < length; level++) {
            int index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null) {
                return false;
            }

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isWordEnd);
    }

    // Returns true if current node is last node else return false
    static boolean isLastNode(TrieNode root)
    {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (root.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    // Recursive function to print auto-suggestions for given node
    static void suggestionsRec(TrieNode root, String currPrefix)
    {
        // Found a string in Trie with given prefix
        if (root.isWordEnd) {
            System.out.println(currPrefix.toString());
        }

        if (isLastNode(root)) {
            return;
        }

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (root.children[i] != null) {
// Append current character to currPrefix string
                currPrefix += ((char)('a' + i));

                // Recur over the rest
                suggestionsRec(root.children[i], currPrefix);

                // Delete this character for other branches, after it was used above
                currPrefix = currPrefix.substring(0, currPrefix.length() - 1);
            }
        }
    }

    // Print suggestions for given query prefix
    static int printAutoSuggestions(TrieNode root, String query)
    {
        TrieNode pCrawl = root;

        // Check if prefix is present and find the node (of last level) with last character of given string
        int level;
        int n = query.length();

        for (level = 0; level < n; level++) {
            int index = query.charAt(level) - 'a';

            // No string in the Trie has this prefix
            if (pCrawl.children[index] == null) {
                return 0;
            }

            pCrawl = pCrawl.children[index];
        }

        // If prefix is present as a word
        boolean isWord = (pCrawl.isWordEnd == true);

        // If prefix is last node of tree (has no children)
        boolean isLast = isLastNode(pCrawl);

        // If prefix is present as a word, but there is no subtree below the last matching node
        if (isWord && isLast) {
            System.out.println(query);
            return -1;
        }

        // If there are more nodes below last matching character
        if (!isLast) {
            String prefix = query;
            suggestionsRec(pCrawl, prefix);
            return 1;
        }

        return 0;
    }

    public static void main(String[] args)
    {
        TrieNode root = new TrieNode();

        insert(root, "hello");
        insert(root, "dog");
        insert(root, "hell");
        insert(root, "cat");
        insert(root, "a");
        insert(root, "hel");
        insert(root, "help");
        insert(root, "helps");
        insert(root, "helping");
        int comp = printAutoSuggestions(root, "hel");


        if (comp == -1) {
            System.out.println("No other strings found with this prefix");
        } else if (comp == 0) {
            System.out.println("No string found with this prefix");
        }
    }
}
