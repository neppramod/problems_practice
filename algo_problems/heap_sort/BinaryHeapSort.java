public class BinaryHeapSort {
    private int max_size;
    private int[] heap;
    private int position;

    
    public static void main(String[] args) {
        int[] a1 = {7, 3, 5, 8};
        BinaryHeapSort binaryHeapSort = new BinaryHeapSort();
        binaryHeapSort.heapSort(a1);
        binaryHeapSort.print();
    }
    

    public void createHeap(int[] arr) {
        heap = arr;
        this.position = heap.length - 1;

        for (int i = position / 2; i >= 0; i--)
            fixHeap(i);
    }

    private void fixHeap(int n) {
        int l = 2 * n;
        int r = 2 * n + 1;
        int largest = n;

        if (l <= position && heap[l] > heap[n])
            largest = l;

        if (r <= position && heap[r] > heap[largest])
            largest = r;

        if (largest != n) {
            swap(n, largest);
            fixHeap(largest);
        }
    }

    public void heapSort(int[] arr) {
        createHeap(arr);

        for (int i = position; i > 0; i--) {
            swap(0, i);
            position--;
            fixHeap(0);
        }
    }

    private void swap(int n, int p) {
        int tmp = heap[n];
        heap[n] = heap[p];
        heap[p] = tmp;
    }

    public void print() {
        for (int i = 0; i < heap.length; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    public int[] getArray() {
        return heap;
    }

}
