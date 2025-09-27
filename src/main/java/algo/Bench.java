package algo;

import java.util.Random;

public class Bench {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = 1000;
        int[] arr1 = rand.ints(n, 0, 10000).toArray();
        int[] arr2 = arr1.clone();

        Metrics.reset();
        long start = System.nanoTime();
        MergeSort.sort(arr1);
        long end = System.nanoTime();
        System.out.printf("MergeSort: %.3f ms, depth=%d, comparisons=%d%n",
                (end - start) / 1e6, Metrics.getMaxDepth(), Metrics.getComparisons());

        Metrics.reset();
        start = System.nanoTime();
        SortUtils.shuffle(arr2);
        QuickSort.sort(arr2);
        end = System.nanoTime();
        System.out.printf("QuickSort: %.3f ms, depth=%d, comparisons=%d%n",
                (end - start) / 1e6, Metrics.getMaxDepth(), Metrics.getComparisons());

        int k = n / 2;
        int kth = DeterministicSelect.select(arr1.clone(), k);
        System.out.println("Deterministic Select (k=" + k + "): " + kth);

        Point2D[] pts = new Point2D[100];
        for (int i = 0; i < pts.length; i++) {
            pts[i] = new Point2D(rand.nextDouble() * 1000, rand.nextDouble() * 1000);
        }
        double d = ClosestPair.findClosest(pts);
        System.out.println("Closest pair distance: " + d);
    }
}
