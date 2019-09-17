import java.util.*;

public class HuffmanEncodingDecoding {

    static class MinHeapNode implements Comparable<MinHeapNode>
    {
        char data;          // One of the input characters
        int freq;           // Frequency of the input character
        MinHeapNode left, right;

        MinHeapNode(char data, int freq)
        {
            this.data = data;
            this.freq = freq;
        }

        public int compareTo(MinHeapNode n)
        {
            return this.freq - n.freq;
        }
    }

    // utility function to store map each character with its
    // frequency in input string
    static HashMap<Character, Integer> calcFreq(String str, int n)
    {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i <str.length(); i++) {
            char key = str.charAt(i);
            if (!freq.containsKey(key)) {
                freq.put(key, 1);
            } else {
                freq.put(key, freq.get(key) + 1);
            }
        }
        return freq;
    }



    // Function to build the Huffman tree and store it
    static MinHeapNode huffmanCodes(HashMap<Character, Integer> freq, int size)
    {

        // Priority queue to store heap tree, with respect to their heap root node value
        PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>();

        for (char key : freq.keySet()) {
            minHeap.add(new MinHeapNode(key, freq.get(key)));
        }

        // Use minHeap to build the tree
        while (minHeap.size() != 1) {
            MinHeapNode left = minHeap.poll();
            MinHeapNode right = minHeap.poll();
            MinHeapNode top = new MinHeapNode('$', left.freq + right.freq);

            top.left = left;
            top.right = right;
            minHeap.add(top);
        }

        // return root node, after huffman tree has been formed
        return minHeap.poll();
    }

    // utility function to store characters along with their huffman value in a
    // hash table (map)
    static void storeCodes(HashMap<Character, String> codes, MinHeapNode root, String str)
    {
        if (root == null) {
            return;
        } else if (root.data != '$') {
            codes.put(root.data, str);
        } else {
            storeCodes(codes, root.left, str + "0");
            storeCodes(codes, root.right, str + "1");
        }

    }

    // Function iterates through the encoded string s
    // if s[i] == '1' then move to node.right
    // if s[i] == '0' then move to node.left
    // if leaf node, append the node.data to output string
    static String decode_file(MinHeapNode root, String s)
    {
        StringBuilder sb = new StringBuilder();
        MinHeapNode curr = root;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                curr = curr.left;
            } else {
                curr = curr.right;
            }

            // reached leaf node
            if (curr.left == null && curr.right == null) {
                sb.append(curr.data);
                curr = root;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        String str = "geeksforgeeks";


        // Store the frequency of character of the input data
        HashMap<Character, Integer> freq = calcFreq(str, str.length());


        // Build huffman tree from character frequency
        MinHeapNode huffmanNode = huffmanCodes(freq, str.length());

        HashMap<Character, String> codes = new HashMap<>();
        storeCodes(codes, huffmanNode, "");  // store huffman value for each character

        System.out.println("Character with their huffman codes");
        for (char code : codes.keySet()) {
            System.out.println(code + " " + codes.get(code));
        }

        StringBuilder encodedSB = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            encodedSB.append(codes.get(str.charAt(i)));
        }
        System.out.println("\nEncoded Huffman data\n" + encodedSB.toString());

        System.out.println("\nDecoded Huffman Data:\n" + decode_file(huffmanNode, encodedSB.toString()));
    }

}
