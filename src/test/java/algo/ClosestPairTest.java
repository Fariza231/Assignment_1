package algo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClosestPairTest {
    @Test
    void testSimple() {
        Point2D[] pts = {
                new Point2D(0,0),
                new Point2D(3,4),
                new Point2D(1,1)
        };
        double d = ClosestPair.findClosest(pts);
        assertEquals(Math.sqrt(2), d, 1e-9);
    }

    @Test
    void testCollinear() {
        Point2D[] pts = {
                new Point2D(0,0), new Point2D(2,0), new Point2D(5,0), new Point2D(1,0)
        };
        double d = ClosestPair.findClosest(pts);
        assertEquals(1.0, d, 1e-9);
    }
}
