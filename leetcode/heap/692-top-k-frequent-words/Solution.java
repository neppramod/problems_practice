/*
  692. Top K Frequent Words

Given a non-empty list of words, return the k most frequent elements.

  Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

  Example 1:
  Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
  Output: ["i", "love"]
  Explanation: "i" and "love" are the two most frequent words.
  Note that "i" comes before "love" due to a lower alphabetical order.
  Example 2:
  Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
  Output: ["the", "is", "sunny", "day"]
  Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
  with the number of occurrence being 4, 3, 2 and 1 respectively.
  Note:
  You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
  Input words contain only lowercase letters.
 */

import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] arr = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        List<String> result = topKFrequent(arr, k);

        System.out.println(result);

    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words) {
            if (!map.containsKey(w)) {
                map.put(w, 1);
            } else {
                map.put(w, map.get(w) + 1);
            }
        }

        PriorityQueue<W> queue = new PriorityQueue<>();
        for (String w : map.keySet()) {
            System.out.println(w + ": " + map.get(w));
            if (queue.size() < k) {
                queue.add(new W(w, map.get(w)));
            } else {
                W w1 = queue.peek();
                int freq1 = map.get(w);
                if (freq1 > w1.getFreq()) {
                    queue.poll();
                    queue.add(new W(w, freq1));
                } else if (freq1 == w1.getFreq()) {
                    if (w.compareTo(w1.word) < 0) {
                        queue.poll();
                        queue.add(new W(w, freq1));
                    }
                }
            }
        }

        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()){
            W w = queue.poll();
            W w1 = queue.peek();
            if (w1 == null) {
                list.add(w1);
            }
        }
        return list;
    }

    static class W implements Comparable<W>
    {
        String word;
        int freq;

        public W(String w, int f) {
            word = w;
            freq = f;
        }

        public void setFreq(int f) {
            freq = f;
        }

        public int getFreq() {
            return freq;
        }

        public int compareTo(W w1) {
            if (w1.freq != freq) {
                return freq - w1.freq;
            } else {
                return word.compareTo(w1.word);
            }
        }
    }

    static void pA1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println();
    }

    static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pA1(arr[i]);
        }
    }
}
