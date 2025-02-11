class MaxHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[maxSize];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (2 * i) + 1;
    }

    private int rightChild(int i) {
        return (2 * i) + 2;
    }

    // Insert a new key into the heap
    public void insertKey(int x) {
        if (size == maxSize) {
            System.out.println("Heap overflow");
            return;
        }

        int i = size;
        heap[size++] = x;

        while (i > 0 && heap[parent(i)] < heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    // Remove the maximum element (root)
    public void removeMax() {
        if (size <= 0) {
            System.out.println("Heap is empty");
            return;
        }
        if (size == 1) {
            size--;
            return;
        }

        heap[0] = heap[size - 1];
        size--;
        maxHeapify(0);
    }

    // Heapify the tree to maintain max heap property
    private void maxHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largest);
        }
    }

    // Get the maximum element
    public int getMax() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        return heap[0];
    }

    // Get the current heap size
    public int heapSize() {
        return size;
    }

    public static void main(String[] args) {
        MaxHeap h = new MaxHeap(15);
        int[] ele = {3, 10, 12, 18, 2, 14};

        for (int e : ele) {
            h.insertKey(e);
        }

        System.out.println("Current size of heap: " + h.heapSize());
        System.out.println("The current maximum element is: " + h.getMax());

        h.removeMax();
        h.removeMax();

        System.out.println("The current size of the heap is: " + h.heapSize());

        h.insertKey(15);
        h.insertKey(20);

        System.out.println("The current maximum element is: " + h.getMax());
    }
}
