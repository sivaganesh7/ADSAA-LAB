class SortingTechniques {
    public void bubbleSort(int[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Bubble Sorted Array: " + java.util.Arrays.toString(arr));
        System.out.println("Time Taken: " + (endTime - startTime) + " nanoseconds");
    }

    public void selectionSort(int[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        long endTime = System.nanoTime();
        System.out.println("Selection Sorted Array: " + java.util.Arrays.toString(arr));
        System.out.println("Time Taken: " + (endTime - startTime) + " nanoseconds");
    }

    public void insertionSort(int[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        long endTime = System.nanoTime();
        System.out.println("Insertion Sorted Array: " + java.util.Arrays.toString(arr));
        System.out.println("Time Taken: " + (endTime - startTime) + " nanoseconds");
    }
}
public class sorting{
    public static void main(String[] args) {
        SortingTechniques s=new SortingTechniques();
        int[] arr = {64, 34, 25, 12, 22,11, 90};
        s.bubbleSort(arr);
        s.selectionSort(arr);
        s.insertionSort(arr);
}}
