package algo;

import java.util.Random;

public class QuickSort {
    private static final Random rand = new Random();

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int lo, int hi) {
        while (lo < hi) {
            Metrics.enter();
            int p = partition(arr, lo, hi);
            if (p - lo < hi - p) {
                sort(arr, lo, p - 1);
                lo = p + 1;
            } else {
                sort(arr, p + 1, hi);
                hi = p - 1;
            }
            Metrics.exit();
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivotIndex = lo + rand.nextInt(hi - lo + 1);
        SortUtils.swap(arr, pivotIndex, hi);
        int pivot = arr[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            Metrics.addComparison();
            if (arr[j] <= pivot) {
                SortUtils.swap(arr, i, j);
                i++;
            }
        }
        SortUtils.swap(arr, i, hi);
        return i;
    }
}
