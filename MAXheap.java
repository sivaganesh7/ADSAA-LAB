class MaxHeap {
    int[] arr;
    int maxSize, heapSize;

    MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        heapSize = 0;
        arr = new int[maxSize];
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int lChild(int i) {
        return 2 * i + 1;
    }

    int rChild(int i) {
        return 2 * i + 2;
    }

    int getMax() {
        return arr[0];
    }

    int curSize() {
        return heapSize;
    }

    void MaxHeapify(int i) {
        int l = lChild(i);
        int r = rChild(i);
        int largest = i;
        if (l < heapSize && arr[l] > arr[i])
            largest = l;
        if (r < heapSize && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            MaxHeapify(largest);
        }
    }

    void removeMax() {
        if (heapSize <= 0)
            System.out.println("Heap is empty");
        if (heapSize == 1)
            heapSize--;
        else {
            arr[0] = arr[heapSize - 1];
            heapSize--;
            MaxHeapify(0);
        }
    }

    void insertKey(int x) {
        if (heapSize == maxSize) {
            System.out.println("\nOverflow: Could not insertKey\n");
            return;
        }

        int i = heapSize;
        arr[i] = x;
        heapSize++;

        while (i != 0 && arr[parent(i)] < arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }
}

public class maxHeap {

    public static void main(String[] args) {
        MaxHeap h = new MaxHeap(15);
        int elements[] = { 3, 10, 12, 8, 2, 14 };

        for (int e : elements)
            h.insertKey(e);

        System.out.println("The current size of the heap is " + h.curSize());
        System.out.println("The current maximum element is " + h.getMax());
        for (int i = 0; i < h.heapSize; i++) {
            System.out.print(" " + h.arr[i]);
        }
        System.out.println();

        h.removeMax();
        for (int i = 0; i < h.heapSize; i++) {
            System.out.print(" " + h.arr[i]);
        }
        System.out.println();
        System.out.println("The current size of the heap is " + h.curSize());

        // Inserting 2 new keys into the heap.
        h.insertKey(15);
        h.insertKey(5);
        System.out.println("The current size of the heap is " + h.curSize());
        System.out.println("The current maximum element is " + h.getMax());
        for (int i = 0; i < h.heapSize; i++) {
            System.out.print(" " + h.arr[i]);
        }
        System.out.println();
    }
}
