import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PointSET {


    private SET<Point2D> points;

    // construct an empty set of points
    public PointSET() {
        this.points = new SET<>();
    }

    public boolean isEmpty() {
        return points.isEmpty();
    }

    // number of points in the set
    public int size() {
        return points.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException("invalid argument");
        points.add(p);
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) throw new IllegalArgumentException("invalid argument");
        return points.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
        for (Point2D point : points) {
            point.draw();
        }
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new IllegalArgumentException("invalid argument");
        List<Point2D> pointsInsideBoundary = new ArrayList<>();

        for (Point2D point2D : points) {
            if (rect.contains(point2D)) {
                pointsInsideBoundary.add(point2D);
            }
        }
        return pointsInsideBoundary;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if (p == null) throw new IllegalArgumentException("invalid argument");
        Point2D nearest = null;
        double distance = 3D;

        for (Point2D point2D : points) {
            if (point2D.compareTo(p) == 0) return point2D;
            double tmp = p.distanceSquaredTo(point2D);
            if (distance > tmp) {
                distance = tmp;
                nearest = point2D;
            }
        }
        return nearest;
    }


    // unit testing of the methods (optional)
    public static void main(String[] args) {
        PointSET pointSET = new PointSET();
        pointSET.insert(new Point2D(0.2D, 0.3D));
        pointSET.insert(new Point2D(0.1D, 0.3D));
        pointSET.insert(new Point2D(0.3D, 0.3D));
        pointSET.insert(new Point2D(0.4D, 0.3D));
        pointSET.insert(new Point2D(0.9D, 0.972D));

        //pointSET.draw();

        RectHV hv = new RectHV(0.3D, 0.5, 0.6, 0.6D);

        Iterable<Point2D> range = pointSET.range(hv);
        for (Point2D point2D : range) {
            point2D.toString();
        }


        Point2D nearest = pointSET.nearest(new Point2D(0.234242, 0.423232));
        System.out.println(nearest);

    }


}
