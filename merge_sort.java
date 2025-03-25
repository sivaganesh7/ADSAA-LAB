public class MergeSort {
    public void mergeSort1(int[] a, int l, int h) {
        if (a == null || a.length <= 1) return;
        mergeSort2(a, l, h);
    }

    public void mergeSort2(int[] a, int l, int h) {
        if (l >= h) return;
        int mid = l + (h - l) / 2;
        mergeSort2(a, l, mid);
        mergeSort2(a, mid + 1, h);
        merge(a, l, mid, h);
    }

    public void merge(int[] a, int l, int mid, int h) {
        int leftSize = mid - l + 1;
        int rightSize = h - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        // Populate left array
        for (int i = 0; i < leftSize; i++) {
            left[i] = a[l + i];  // Fixed: was a[l+1]
        }

        // Populate right array
        for (int i = 0; i < rightSize; i++) {
            right[i] = a[mid + 1 + i];
        }

        int i = 0, j = 0, k = l;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

        while (i < leftSize) {
            a[k++] = left[i++];
        }

        while (j < rightSize) {
            a[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] a = {3, 6, 8, 10, 1, 4, 7};

        ms.mergeSort1(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
