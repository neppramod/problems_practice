import java.util.*;

public class Solution
{
    /* Find smaller strings in a large string. Save smaller strings in trie with end marker. Go through each character of big string and see if there is a string starting from that index in trie that has ending */

    private static class TrieNode
    {
        TrieNode nodes[] = new TrieNode[26];
        boolean ends = false;
    }

    private static class Trie
    {
        TrieNode root = new TrieNode();

        public void add(String s)
        {
            for (int i = 0; i < s.length(); i++) {
                int sIndex = s.charAt(i) - 'a';
                root.nodes[sIndex] = new TrieNode();
                root = root.nodes[sIndex];
            }
            root.ends = true;
        }

        public boolean find(String s)
        {
            for (int i = 0; i < s.length(); i++) {
                int sIndex = s.charAt(i) - 'a';
                if (root.nodes[sIndex] != null) {
                    root = root.nodes[sIndex];
                    if (root.ends) {return true;}

                } else {
                    return false;
                }

            }

            return false;
        }
    }

    private static ArrayList<Integer> findLocations(String b, String[] T)
    {
        ArrayList<Integer> locations = new ArrayList<>();
        Trie trie = new Trie();
        for (String t : T) {
            trie.add(t);
        }

        for (int i = 0; i < b.length(); i++) {
            if (trie.find(b.substring(i))) locations.add(i);
        }

        return locations;
    }

    public static void main(String[] args)
    {

        String[] T = new String[] {"is", "ppi", "hi", "sis", "i", "ssipi"};
        String b = "mississippi";

        System.out.println(findLocations(b, T));
    }
}
