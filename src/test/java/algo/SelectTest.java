package algo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import java.util.Arrays;

class SelectTest {

    @Test
    void testSelectMedian() {
        Random r = new Random(3);
        int[] a = r.ints(101, 0, 10000).toArray();
        int[] sorted = Arrays.copyOf(a, a.length);
        Arrays.sort(sorted);

        int k = 50;
        int val = DeterministicSelect.select(Arrays.copyOf(a, a.length), k);

        assertEquals(sorted[k], val, "k-th order statistic mismatch");
    }

    @Test
    void testSelectSmall() {
        int[] a = {7, 10, 4, 3, 20, 15};
        int[] sorted = Arrays.copyOf(a, a.length);
        Arrays.sort(sorted);

        int k = 2;
        int val = DeterministicSelect.select(Arrays.copyOf(a, a.length), k);

        assertEquals(sorted[k], val, "k-th order statistic mismatch in small array");
    }

    @Test
    void testWithDuplicates() {
        int[] a = {5, 5, 5, 7, 7, 9, 1};
        int[] sorted = Arrays.copyOf(a, a.length);
        Arrays.sort(sorted);

        int k = 3;
        int val = DeterministicSelect.select(Arrays.copyOf(a, a.length), k);

        assertEquals(sorted[k], val, "k-th order statistic mismatch with duplicates");
    }
}
