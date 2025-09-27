package algo;

public class DeterministicSelect {

    public static int select(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 0 || k >= arr.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        return select(arr, 0, arr.length - 1, k);
    }

    private static int select(int[] arr, int lo, int hi, int k) {
        if (lo == hi) {
            return arr[lo];
        }

        int pivotIndex = medianOfMedians(arr, lo, hi);
        pivotIndex = partition(arr, lo, hi, pivotIndex);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return select(arr, lo, pivotIndex - 1, k);
        } else {
            return select(arr, pivotIndex + 1, hi, k);
        }
    }

    private static int partition(int[] arr, int lo, int hi, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        SortUtils.swap(arr, pivotIndex, hi);
        int storeIndex = lo;

        for (int i = lo; i < hi; i++) {
            if (arr[i] <= pivotValue) {   // 👈 добавил "="
                SortUtils.swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        SortUtils.swap(arr, storeIndex, hi);
        return storeIndex;
    }

    private static int medianOfMedians(int[] arr, int lo, int hi) {
        int n = hi - lo + 1;
        if (n < 5) {
            insertionSort(arr, lo, hi);
            return lo + (hi - lo) / 2;   // 👈 исправил
        }

        int numMedians = (int) Math.ceil((double) n / 5);
        for (int i = 0; i < numMedians; i++) {
            int subLo = lo + i * 5;
            int subHi = Math.min(subLo + 4, hi);
            insertionSort(arr, subLo, subHi);
            int medianIndex = subLo + (subHi - subLo) / 2;
            SortUtils.swap(arr, lo + i, medianIndex);
        }
        return medianOfMedians(arr, lo, lo + numMedians - 1);
    }

    private static void insertionSort(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= lo && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
