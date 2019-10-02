import java.util.*;

public class Solution
{

    static class Node
    {
        char data;    // one of the input character
        int freq;     // frequency of the input character
        Node left, right;

        public Node(char data, int freq)
        {
            this.data = data;
            this.freq = freq;
        }
    }

    static Queue<Node> firstQueue = new LinkedList<>();
    static Queue<Node> secondQueue = new LinkedList<>();

    static Node getMin() {
        if (firstQueue.isEmpty()) {
            return secondQueue.poll();
        }
        if (secondQueue.isEmpty()) {
            return firstQueue.poll();
        }

        Node m = secondQueue.peek();
        Node n = firstQueue.peek();
        if (m.freq < n.freq) {
            return secondQueue.poll();
        }

        return firstQueue.poll();
    }



    static void printCodes(Node root, String str)
    {
        if (root == null) {
            return;
        }

        if (root.data != '$') {
            System.out.println(root.data + " ");
        }

        printCodes(root.left, str + "0");
        printCodes(root.right, str + "1");
    }

    public static void main(String[] args)
    {
        char arr[] = {'a', 'b', 'c', 'd', 'e', 'f'};
        int freq[] = {5, 9, 12, 13, 16, 45};
        int size = arr.length;


        for (int i = 0; i < size; i++) {
            firstQueue.add(new Node(arr[i], freq[i]));
        }

        Node left, right, top;
        while (!(firstQueue.isEmpty() && secondQueue.size() == 1)) {
            left = getMin();
            right = getMin();
            top = new Node('$', left.freq + right.freq);
            top.left = left;
            top.right = right;
            secondQueue.add(top);
        }

        Node f = secondQueue.peek();
        printCodes(f, "");

    }

}
