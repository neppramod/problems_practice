import java.util.*;
import java.io.*;

public class ExternalSorting
{
    static class MinHeapNode implements Comparable<MinHeapNode>
    {
        int element;
        int i; // index of array from which it is picked

        public MinHeapNode(int el, int i1)
        {
            element = el;
            i = i1;
        }

        public int compareTo(MinHeapNode n)
        {
            if (element < n.element) {
                return -1;
            } else if (element > n.element) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    static void mergeKSortedFiles(String outputFileName, int k) throws Exception
    {
        Scanner[] sc = new Scanner[k];
        for (int i = 0; i < k; i++) {
            String fileName = String.format("%d", i);
            sc[i] = new Scanner(new File(fileName));
        }

        MinHeapNode[] minHeapNodeArr = new MinHeapNode[k];
        PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>();

        int i;
        for (i = 0; i < k; i++) {
            if (!sc[i].hasNext()) {
                break;
            }
            String nextData = sc[i].next();
            minHeapNodeArr[i] = new MinHeapNode(Integer.parseInt(nextData), i);
            minHeap.add(minHeapNodeArr[i]);
        }


        int count = 0;

        // Now one by one get the minimum element from min heap and replace it with the next element
        // run this all filled input files reach EOF
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
        while (count != i) {
            MinHeapNode root = minHeap.poll();
            writer.write(root.element + " ");

            if (!sc[root.i].hasNext()) {
                root.element = Integer.MAX_VALUE;
                count++;
            } else {
                root.element = sc[root.i].nextInt();
            }

            minHeap.add(root);
        }

        // close input output files
        for (int j = 0; j < k ; j++) {
            sc[j].close();
        }
        writer.close();

    }

    public static void main(String args[]) throws Exception{
        mergeKSortedFiles("outputfile.txt", 3);
    }
}
