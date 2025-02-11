class MinHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MinHeap(int maxSize) {
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

        // Swap with parent until min heap property is restored
        while (i > 0 && heap[parent(i)] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    // Remove the minimum element (root)
    public void removeMin() {
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
        minHeapify(0);
    }

    // Heapify the tree to maintain min heap property
    private void minHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            minHeapify(smallest);
        }
    }

    // Get the minimum element
    public int getMin() {
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
}
public class Main{ 
    public static void main(String[] args) {
        MinHeap h = new MinHeap(15);
        int[] ele = {18, 14, 10, 3, 2, 12};

        for (int e : ele) {
            h.insertKey(e);
        }

        System.out.println("Current size of heap: " + h.heapSize());
        System.out.println("The current minimum element is: " + h.getMin());

        h.removeMin();

  
        System.out.println("The current minimum element is: " + h.getMin()+" after deletion ");
        h.insertKey(1);

        System.out.println("The current size of the heap is: " + h.heapSize());
        System.out.println("The current minimum element is: " + h.getMin());
    }
}
