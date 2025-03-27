import java.util.*;

public class QuickSortAnalysis {
    public static void quicksort(int[] a, int low, int high) {
        if (low < high) {
            int j = partition(a, low, high);
            quicksort(a, low, j - 1);
            quicksort(a, j + 1, high);
        }
    }

    public static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low + 1;
        int j = high;
        while (i < j) {
            while (i < j && a[i] <= pivot) {
                i++;
            }
            while (i <= j && a[j] >= pivot) {
                j--;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, j, low);
        return j;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void measureExecutionTime(int[] arr, String caseType) {
        int[] copy = Arrays.copyOf(arr, arr.length); // Create a copy to avoid modifying the original array
        long startTime = System.nanoTime();
        quicksort(copy, 0, copy.length - 1);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println(caseType + " Case Execution Time: " + executionTime + " ns");
        System.out.println("Sorted " + caseType + " Case Array: " + Arrays.toString(copy));
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Array size: ");
        int n = s.nextInt();

        int[] avgCase = new int[n]; // Random elements
        int[] bestCase = new int[n]; // Already sorted
        int[] worstCase = new int[n]; // Reverse sorted

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            avgCase[i] = rand.nextInt(1000); // Random numbers between 0 and 999
            bestCase[i] = i; // Sorted order
            worstCase[i] = n - i; // Reverse order
        }

        measureExecutionTime(bestCase, "Best");
        measureExecutionTime(worstCase, "Worst");
        measureExecutionTime(avgCase, "Average");

        s.close();
    }
}
