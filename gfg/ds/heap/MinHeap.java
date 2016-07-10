public class MinHeap
{
    int[] harr;
    int capacity;
    int heap_size;

    private void swap(int i, int j)
    {
        int tmp = harr[i];
        harr[i] = harr[j];
        harr[j] = tmp;
    }

    public MinHeap(int cap)
    {
        this.capacity = cap;
    }

    public int left(int i)
    {
        return 2 * i + 1;
    }
    public int right(int i)
    {
        return 2 * i + 2;
    }
    public int parent(int i)
    {
        return (i-1) / 2;
    }

    void MinHeapify(int i)
    {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if (l < heap_size && harr[l] < harr[i])
            smallest = l;
        else if (r < heap_size && harr[r] < harr[i])
            smallest = r;

        if (smallest != i) {
            swap(smallest, i);
            MinHeapify(smallest);
        }
    }

    int extractMin()
    {
        if (heap_size <= 0)
            return Integer.MAX_VALUE;

        int min = harr[0];
        harr[0] = harr[heap_size-1];
        heap_size--;
        MinHeapify(0);
        return min;
    }


    void insert(int k)
    {

		if (heap_size == capacity)
		{
			System.out.println("Overflow, could not insert key");
			return;
		}

        heap_size++;
        /*
        heap[heap_size-1] = k;
        swap(0, heap_size-1);
        MinHeapify(0);
        */

        int i = heap_size - 1;
        harr[i] = k;

        while (i != 0 && harr[parent(i)] > harr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    void decreaseKey(int i, int new_val)
    {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    void deleteKey(int i)
    {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }
}

