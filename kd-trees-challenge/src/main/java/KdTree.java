import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.List;


// implementation using 2d-tree
public class KdTree {


    private Node root = null;
    private int size = 0;

    private class Node {

        private Point2D point;
        private int level;

        private Node left;
        private Node right;

        public Node(Point2D point, int level) {
            this.point = point;
            this.level = level;
        }
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
        this.root = insert(this.root, p, 0);
    }

    /**
     * Search and insert. The algorithms for search and insert are similar to those for BSTs, but at the root we use
     * the x-coordinate (if the point to be inserted has a smaller x-coordinate than the point at the root, go left;
     * otherwise go right); then at the next level, we use the y-coordinate (if the point to be inserted has a smaller
     * y-coordinate than the point in the node, go left; otherwise go right); then at the next level the x-coordinate,
     * and so forth.
     */
    private Node insert(Node node, Point2D newPoint, int prevLevel) {
        // navigation
        if (node != null) {
            /**
             * odd = x-coordinate
             * even = y-coordinate
             */
            if (node.level % 2 != 0) {
                if (newPoint.x() < node.point.x()) {
                    node.left = insert(node.left, newPoint, node.level);
                } else {
                    node.right = insert(node.right, newPoint, node.level);
                }
            } else {
                if (newPoint.y() < node.point.y()) {
                    node.left = insert(node.left, newPoint, node.level);
                } else {
                    node.right = insert(node.right, newPoint, node.level);
                }
            }
        } else {
            // node null
            node = new Node(newPoint, prevLevel + 1);
        }

        return node;
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        return false;
    }

    // draw all points to standard draw
    public void draw() {
        StdDraw.rectangle(0, 0, 1, 1);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.02);
        draw(root);

    }

    private void draw(Node node) {
        if (node == null) {
            System.out.println("End");
            return;
        }
        StdDraw.rectangle(0, 0, 1, 1);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.02);

        System.out.println("render: " + node.point.toString());
        node.point.draw();

        draw(node.left);
        draw(node.right);

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
        KdTree kdTree = new KdTree();
        kdTree.insert(new Point2D(0.7D, 0.2D));
        kdTree.insert(new Point2D(0.5D, 0.4D));
        kdTree.insert(new Point2D(0.2D, 0.3D));
        kdTree.insert(new Point2D(0.4D, 0.7D));
        kdTree.insert(new Point2D(0.9D, 0.6D));


        kdTree.draw();

    }


}
