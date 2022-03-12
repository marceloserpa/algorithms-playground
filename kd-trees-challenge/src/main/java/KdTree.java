import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

import java.util.ArrayList;
import java.util.List;

public class KdTree {


    private class Node {

    }

    // construct an empty set of points
    public KdTree() {

    }

    public boolean isEmpty() {
        return false;
    }

    // number of points in the set
    public int size() {
        return 0;
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {

    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
     return false;
    }

    // draw all points to standard draw
    public void draw() {

    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {

        return null;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {

        /**

        Point2D nearest = null;
        double distance = 0D;

        for(Point2D point2D : points) {
            if(nearest == null) {
                nearest = point2D;
                distance = p.distanceTo(nearest);
            } else {

                double tmp = p.distanceTo(nearest);
                if(distance > tmp) {
                    distance = tmp;
                    nearest = p;
                }


            }

        }


        return nearest;***/
        return null;
    }


    // unit testing of the methods (optional)
    public static void main(String[] args) {
        KdTree pointSET = new KdTree();
        pointSET.insert(new Point2D(0.2D,0.3D));
        pointSET.insert(new Point2D(0.1D,0.3D));
        pointSET.insert(new Point2D(0.3D,0.3D));
        pointSET.insert(new Point2D(0.4D,0.3D));
        pointSET.insert(new Point2D(0.9D,0.972D));

        //pointSET.draw();

        RectHV hv = new RectHV(0.3D, 0.5, 0.6, 0.6D);

        Iterable<Point2D> range = pointSET.range(hv);
        for(Point2D point2D: range) {
            point2D.toString();
        }


        Point2D nearest = pointSET.nearest(new Point2D(0.234242, 0.423232));
        System.out.println(nearest);

    }


}
