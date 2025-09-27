package algo;

public class Metrics {
    private static int depth = 0;
    private static int maxDepth = 0;
    private static long comparisons = 0;

    public static void enter() {
        depth++;
        if (depth > maxDepth) {
            maxDepth = depth;
        }
    }

    public static void exit() {
        depth--;
    }

    public static void reset() {
        depth = 0;
        maxDepth = 0;
        comparisons = 0;
    }

    public static void addComparison() {
        comparisons++;
    }

    public static int getMaxDepth() {
        return maxDepth;
    }

    public static long getComparisons() {
        return comparisons;
    }
}
