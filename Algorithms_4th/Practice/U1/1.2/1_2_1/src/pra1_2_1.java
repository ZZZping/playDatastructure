/**
 * 1.2.1 Write a Point2D client that takes an integer value N from the command line,
 * generates N random points in the unit square, and computes the distance separating
 * the closest pair of points.
 */

import edu.princeton.cs.algs4.*;

public class pra1_2_1 {
    public pra1_2_1(){

    }
    public static void drawbox(double bw, double bh) {
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.RED);
        Interval1D xinterval = new Interval1D(0, bw);
        Interval1D yinterval = new Interval1D(0, bh);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();
    }

    public static Point2D[] drawpoint(int N) {
        Point2D[] p = new Point2D[N];
        for (int i = 0; i < N; i ++) {
            double x = Math.random();
            double y = Math.random();
            p[i] = new Point2D(x, y);
        }
        return p;
    }

    public static double findminist(Point2D[] p) {
        Point2D p1 = p[0];
        Point2D p2 = p[1];
        double mindist = p[0].distanceTo(p[1]);
        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(StdDraw.RED);
        int n = p.length;
        for (int i = 1; i < n - 1; i ++) {
            for (int j = i + 1; j < n; j ++) {
                double temp = p[i].distanceTo(p[j]);
                if (temp < mindist) {
                    mindist = temp;
                    p1 = p[i];
                    p2 = p[j];
                }
            }
        }
        p1.drawTo(p2);
        StdOut.print("min dist = " + mindist + p1.toString() + p2.toString());
        return mindist;
    }
}
