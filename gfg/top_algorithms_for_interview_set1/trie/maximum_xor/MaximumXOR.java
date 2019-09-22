import java.util.*;

public class MaximumXOR
{
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[2];
        boolean isLeaf = false;
    }

    // Check if ith position in N is a 1
    static int check(int N, int i)
    {
        return ((N >> (i)) & 1) == 1 ? 1 : 0;
    }

    // Inserts x into the Trie
    static void insert(TrieNode root, int x)
    {
        TrieNode crawler = root;

        // padding upto 32 bits
        for (int i = 31; i >= 0; i--) {
            int f = check(x, i);
            //System.out.println("F: " + f + ", X: " + x);

            if (crawler.children[f] == null) {
                crawler.children[f] = new TrieNode();
            }
            crawler = crawler.children[f];
        }

        crawler.isLeaf = true;
    }

    // Finds maximum XOR of x with stream of elements so far
    static int query2(TrieNode root, int x)
    {
        TrieNode crawler = root;

        // Do XOR from root to a leaf path
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            // Find i-th bit in x
            int f = check(x, i);

            // Move to the child whose XOR with f is 1
            if (crawler.children[f^1] != null) {
                ans = ans + (1 << i);    // update answer
                crawler = crawler.children[f ^ 1];
            } else { // if child with XOR 1 doesn't exist
                crawler = crawler.children[f];
            }
        }

        return ans;
    }

    // Add x to the stream
    static void query1(TrieNode root, int x)
    {
        insert(root, x);
    }

    public static void main(String[] args)
    {

        TrieNode root = new TrieNode();
        query1(root, 10);
        query1(root, 13);

        System.out.println(query2(root, 10));

        query1(root, 9);
        query1(root, 5);

        System.out.println(query2(root, 6));
    }
}
