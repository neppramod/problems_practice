import java.util.*;
import java.io.*;

public class KMostFrequentWordsHashTable
{
    private static class MinHeapNode implements Comparable<MinHeapNode>
    {
        String word;
        int frequency;

        public MinHeapNode(String word, int frequency)
        {
            this.word = word;
            this.frequency = frequency;
        }

        public String toString() {return word + " : " + frequency;}
        public int compareTo(MinHeapNode n) { return frequency - n.frequency; }
    }

    public static void insertIntoHashTable(HashMap<String, Integer> hashTable, String word)
    {
        // Insert into hash table
        if (hashTable.containsKey(word)) {
            hashTable.put(word, hashTable.get(word) + 1);
        } else {
            hashTable.put(word, 1);
        }
    }

    public static void insertAndUpdateHeap(HashMap<String, Integer> hashTable, PriorityQueue<MinHeapNode> minHeap, int k)
    {
        for (String key : hashTable.keySet()) {
            int frequency = hashTable.get(key);
            if (minHeap.size() < k) {
                minHeap.add(new MinHeapNode(key, frequency));
            } else {
                if (frequency > minHeap.peek().frequency) {
                    MinHeapNode topNode = minHeap.poll();
                    topNode. word = key;
                    topNode.frequency = frequency;
                    minHeap.add(topNode);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>();
        HashMap<String, Integer> hashTable = new HashMap<>();
        int k = 5;

        Scanner sc = new Scanner(new File("file.txt"));
        while(sc.hasNext()) {
            insertIntoHashTable(hashTable, sc.next());
        }

        insertAndUpdateHeap(hashTable, minHeap, k);

        System.out.println(minHeap);
    }
}
