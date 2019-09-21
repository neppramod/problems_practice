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

    public static void insertIntoHashTable(HashMap<String, Integer> hashMap, String word)
    {
        // Insert into hash table
        if (hashMap.containsKey(word)) {
            hashMap.put(word, hashMap.get(word) + 1);
        } else {
            hashMap.put(word, 1);
        }
    }

    public static void insertAndUpdateHeap(HashMap<String, Integer> hashMap, PriorityQueue<MinHeapNode> minHeap, int k)
    {
        for (String key : hashMap.keySet()) {
            int frequency = hashMap.get(key);
            if (minHeap.size() < k) {
                minHeap.add(new MinHeapNode(key, frequency));
            } else if (frequency > minHeap.peek().frequency) {
                    MinHeapNode topNode = minHeap.poll();
                    topNode. word = key;
                    topNode.frequency = frequency;
                    minHeap.add(topNode);

            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int k = 5;

        Scanner sc = new Scanner(new File("file.txt"));
        while(sc.hasNext()) {
            insertIntoHashTable(hashMap, sc.next());
        }

        insertAndUpdateHeap(hashMap, minHeap, k);

        System.out.println(minHeap);
    }
}
