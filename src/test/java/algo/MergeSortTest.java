package algo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import java.util.Arrays;

class MergeSortTest {
    @Test
    void testRandomSort() {
        Random r = new Random(1);
        int[] a = r.ints(1000, -10000, 10000).toArray();
        int[] expected = Arrays.copyOf(a, a.length);
        Arrays.sort(expected);
        MergeSort.sort(a);
        assertArrayEquals(expected, a);
    }

    @Test
    void testSmall() {
        int[] a = {5,2,3,1};
        MergeSort.sort(a);
        assertArrayEquals(new int[]{1,2,3,5}, a);
    }
}
