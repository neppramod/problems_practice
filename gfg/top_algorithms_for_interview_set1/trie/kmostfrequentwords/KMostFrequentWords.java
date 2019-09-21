import java.util.*;
import java.io.*;

public class KMostFrequentWords
{
    static class Trie
    {
        boolean isEndOfWord = false;
        int frequency = 0;
        Trie[] child = new Trie[26];
        MinHeapNode heapNode = null;
    }

    static class MinHeapNode implements Comparable<MinHeapNode>
    {
        String word;
        int frequency;
        Trie trieNode;

        public MinHeapNode(String word, int frequency)
        {
            this.word = word;
            this.frequency = frequency;
        }

        public int compareTo(MinHeapNode n)
        {
            return frequency - n.frequency;
        }

        public String toString() {
            return word + ": " + frequency;
        }
    }

    // insert key into trie, if prefix mark end of key as leaf, update heap
    private static void insertAndUpdateHeap(Trie root, String key, PriorityQueue<MinHeapNode> minHeap, int k)
    {
        Trie cur = root;
        for (int i = 0; i < key.length(); i++) {

            int index = Character.toLowerCase(key.charAt(i)) - 'a';
            if (cur.child[index] == null) {
                cur.child[index] = new Trie();
            }

            cur = cur.child[index];
        }



        // mark cur as leaf
        cur.isEndOfWord = true;
        cur.frequency = cur.frequency + 1;

        // Case 1, word is already present in minHeap
        if (cur.heapNode != null) {

            // Unless removed heap will not sort
            minHeap.remove(cur.heapNode);
            cur.heapNode.frequency = cur.frequency;
            minHeap.add(cur.heapNode);

            // Case 2, word is not present and heap is not full
        } else if (cur.heapNode == null && minHeap.size() < k) {
            cur.heapNode = new MinHeapNode(key, cur.frequency);
            cur.heapNode.trieNode = cur;
            minHeap.add(cur.heapNode);

            // Case 3, word is not present and heap is full, and frequency is more than top of minHeap, replace it
        } else if (cur.heapNode == null && cur.frequency > minHeap.peek().frequency) {
            MinHeapNode minHeapRoot = minHeap.poll();
            minHeapRoot.trieNode = cur;
            minHeapRoot.frequency = cur.frequency;
            minHeapRoot.word = key;
            cur.heapNode = minHeapRoot;
            minHeap.add(minHeapRoot);
        }

    }

    public static void main(String[] args) throws Exception
    {
        PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>();
        Trie root = new Trie();
        int k = 5;

        Scanner sc = new Scanner(new File("file.txt"));
        while(sc.hasNext()) {
            insertAndUpdateHeap(root, sc.next(), minHeap, k);
        }

        System.out.println(minHeap);
    }
}
