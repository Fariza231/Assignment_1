package algo;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    public static double findClosest(Point2D[] pts) {
        if (pts == null || pts.length < 2) return Double.POSITIVE_INFINITY;
        Point2D[] px = pts.clone();
        Point2D[] py = pts.clone();
        Arrays.sort(px, Comparator.comparingDouble(p -> p.x));
        Arrays.sort(py, Comparator.comparingDouble(p -> p.y));
        double d2 = rec(px, py, 0, px.length - 1);
        return Math.sqrt(d2);
    }

    private static double rec(Point2D[] px, Point2D[] py, int lo, int hi) {
        int n = hi - lo + 1;
        if (n <= 3) {
            double best = Double.POSITIVE_INFINITY;
            for (int i = lo; i <= hi; i++) {
                for (int j = i + 1; j <= hi; j++) {
                    best = Math.min(best, px[i].dist(px[j]));
                }
            }
            return best;
        }
        int mid = (lo + hi) >>> 1;
        double midx = px[mid].x;

        Point2D[] pyl = new Point2D[mid - lo + 1];
        Point2D[] pyr = new Point2D[hi - mid];
        int li = 0, ri = 0;
        for (Point2D p : py) {
            if (p.x <= midx && li < pyl.length) pyl[li++] = p;
            else if (ri < pyr.length) pyr[ri++] = p;
        }
        if (li < pyl.length || ri < pyr.length) {
            li = ri = 0;
            for (Point2D p : py) {
                if (p.x <= midx) {
                    if (li < pyl.length) pyl[li++] = p;
                } else {
                    if (ri < pyr.length) pyr[ri++] = p;
                }
            }
        }

        double dl = rec(px, pyl, lo, mid);
        double dr = rec(px, pyr, mid + 1, hi);
        double d = Math.min(dl, dr);

        Point2D[] strip = new Point2D[py.length];
        int si = 0;
        for (Point2D p : py) {
            double dx = p.x - midx;
            if (dx*dx < d) strip[si++] = p;
        }

        for (int i = 0; i < si; i++) {
            for (int j = i + 1; j < si && (strip[j].y - strip[i].y)*(strip[j].y - strip[i].y) < d; j++) {
                d = Math.min(d, strip[i].dist(strip[j]));
            }
        }
        return d;
    }
}
