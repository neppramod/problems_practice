import java.util.*;

public class Solution
{
    static final int MAX = 26;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String replaced = replaceWords(dict, sentence);
        System.out.println(replaced);

    }


    public static String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        for (String d : dict) {
            insert(root, d);
        }

        String[] splitSentence = sentence.split(" ");

        String[] joined = new String[splitSentence.length];

        for (int i = 0; i < splitSentence.length; i++) {
            String s = splitSentence[i];
            String f = find(root, s);

            if (f == null) {
                joined[i] = s;
            } else {
                joined[i] = f;
            }

        }

        return String.join(" ", joined);
    }

    static void insert(TrieNode root, String query) {
        TrieNode node = root;
        for (char ch : query.toCharArray()) {
            int chInd = ch - 'a';
            if(node.child[chInd] == null) {
                node.child[chInd] = new TrieNode();
            }
            node = node.child[chInd];
        }

        node.isLeaf = true;
    }

    static String find(TrieNode root, String query)
    {
        StringBuilder sb = new StringBuilder();
        TrieNode node = root;
        for (char ch : query.toCharArray()) {
            int chInd = ch - 'a';
            if (node.child[chInd] != null) {
                sb.append(ch);
                if (node.child[chInd].isLeaf) {
                    return sb.toString();
                }
            } else {
                break;
            }
            node = node.child[chInd];
        }

        return null;
    }

    static class TrieNode
    {
        TrieNode[] child  = new TrieNode[MAX];
        boolean isLeaf = false;
    }

}
