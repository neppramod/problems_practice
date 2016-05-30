import java.util.*;
import java.io.*;

/**
 * Binary Heap Sort using ramsey r44_11.g6 as input
 */
public class BinaryHeapSortRamsey
{
    private String[] heap; // String heap
    private int position;  // Position in the heap
    private static final String INPUT_FILE_NAME = "r44_11.g6"; // Ramsey input file
    private static final String OUTPUT_FILE_NAME = "ramsey_output.txt"; // Generated output file


    public static void main(String[] args) {
        //String[] a1 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"}; // Test example
        BinaryHeapSortRamsey binaryHeapSort = new BinaryHeapSortRamsey();
        binaryHeapSort.heapSort(ramseyStringArr());
        //binaryHeapSort.print();
        binaryHeapSort.printToFile(OUTPUT_FILE_NAME);
    }


    /* Reach the input String array from ramsey r44_11.g6 file. */
    private static String[] ramseyStringArr()
    {
        // Input array list
        ArrayList<String> inputList = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(INPUT_FILE_NAME));
            while (sc.hasNextLine()) {
                inputList.add(sc.nextLine());
            }
            sc.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return inputList.toArray(new String[inputList.size()]);
    }

    /* Heap build  function */
    public void createHeap(String[] arr) {
        heap = arr;
        this.position = heap.length - 1;

        for (int i = position / 2; i >= 0; i--)
            fixHeap(i);
    }

    /* Fix the heap using max-heapify */
    private void fixHeap(int n) {
        int l = 2 * n;
        int r = 2 * n + 1;
        int largest = n;

        if (l <= position && heap[l].compareTo(heap[n]) > 0)
            largest = l;

        if (r <= position && heap[r].compareTo(heap[largest]) > 0)
            largest = r;

        if (largest != n) {
            swap(n, largest);
            fixHeap(largest);
        }
    }

    /* Sort the heap by pushing the 0th element to last position */
    public void heapSort(String[] arr) {
        createHeap(arr);

        for (int i = position; i > 0; i--) {
            swap(0, i);
            position--;
            fixHeap(0);
        }
    }

    private void swap(int n, int p) {
        String tmp = heap[n];
        heap[n] = heap[p];
        heap[p] = tmp;
    }

    public void print() {
        for (int i = 0; i < heap.length; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    /* Write to file */
    public void printToFile(String filename) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(filename));

            for (int i = 0; i < heap.length; i++)
                out.println(heap[i]);

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        System.out.println();
    }
}
