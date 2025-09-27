package algo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import java.util.Arrays;

class QuickSortTest {
    @Test
    void testRandomSort() {
        Random r = new Random(2);
        int[] a = r.ints(1000, -5000, 5000).toArray();
        int[] expected = Arrays.copyOf(a, a.length);
        Arrays.sort(expected);
        QuickSort.sort(a);
        assertArrayEquals(expected, a);
    }

    @Test
    void testSmall() {
        int[] a = {3,1,2};
        QuickSort.sort(a);
        assertArrayEquals(new int[]{1,2,3}, a);
    }
}
