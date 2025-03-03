import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    
    // Quick Sort Implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Merge Sort Implementation
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] sizes = {10, 8, 5}; // Different sizes
        Random random = new Random();
        
        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt(size);
            }
            
            System.out.println("\nArray Size: " + size);
            System.out.println("Original Array: " + Arrays.toString(arr));
            
            int[] quickSortArr = arr.clone();
            measureTime("Quick Sort", quickSortArr, true);
            
            int[] mergeSortArr = arr.clone();
            measureTime("Merge Sort", mergeSortArr, false);
        }
    }

    private static void measureTime(String caseType, int[] arr, boolean isQuickSort) {
        long startTime = System.nanoTime();
        if (isQuickSort) {
            quickSort(arr, 0, arr.length - 1);
        } else {
            mergeSort(arr, 0, arr.length - 1);
        }
        long endTime = System.nanoTime();
        
        System.out.println(caseType + " Sorted Array: " + Arrays.toString(arr));
        System.out.println(caseType + " Execution Time: " + (endTime - startTime) / 1e6 + " ms");
    }
}
