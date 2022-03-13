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
        private RectHV rectHV;
        private int level;

        private Node left;
        private Node right;

        public Node(Point2D point, RectHV rectHV, int level) {
            this.point = point;
            this.rectHV = rectHV;
            this.level = level;
        }

        public boolean isX() {
            return this.level % 2 != 0;
        }
    }

    // construct an empty set of points
    public KdTree() {
    }

    public boolean isEmpty() {
        return root == null;
    }

    // number of points in the set
    public int size() {
        return this.size;
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if(p == null ) throw new IllegalArgumentException("parameter cannot be null");

        if (this.root == null) {
            RectHV rectHV = new RectHV(0, 0, 1, 1);
            this.root = new Node(p, rectHV, 1);
            this.size++;
            return;
        }


        if (this.contains(p)) {
            return;
        }
        this.size++;
        this.root = insert(this.root, this.root.rectHV, p, 0);
    }

    /**
     * Search and insert. The algorithms for search and insert are similar to those for BSTs, but at the root we use
     * the x-coordinate (if the point to be inserted has a smaller x-coordinate than the point at the root, go left;
     * otherwise go right); then at the next level, we use the y-coordinate (if the point to be inserted has a smaller
     * y-coordinate than the point in the node, go left; otherwise go right); then at the next level the x-coordinate,
     * and so forth.
     */

    private Node insert(Node node, RectHV rectHV, Point2D newPoint, int prevLevel) {
        // navigation
        if (node != null) {
            /**
             * odd = x-coordinate
             * even = y-coordinate
             */
            if (node.isX()) {
                if (newPoint.x() < node.point.x()) {
                    RectHV area = null;
                    if (node.left == null) {
                        // calculate half-left
                        //new RectHV()

                        double xmin = node.rectHV.xmin();
                        double ymin = node.rectHV.ymin();
                        double xmax = node.point.x();
                        double ymax = node.rectHV.ymax();

                        area = new RectHV(xmin, ymin, xmax, ymax);

                    }

                    if (area == null) {
                        area = node.left.rectHV;
                    }

                    node.left = insert(node.left, area, newPoint, node.level);
                } else {
                    RectHV area = null;
                    if (node.right == null) {
                        // calculate half-right
                        //new RectHV()

                        double xmin = node.point.x();
                        double ymin = node.rectHV.ymin();
                        double xmax = node.rectHV.xmax();
                        double ymax = node.rectHV.ymax();

                        area = new RectHV(xmin, ymin, xmax, ymax);

                    }

                    if (area == null) {
                        area = node.right.rectHV;
                    }

                    node.right = insert(node.right, area, newPoint, node.level);
                }
            } else {
                if (newPoint.y() < node.point.y()) {

                    RectHV area = null;
                    if (node.left == null) {
                        // calculate half-left
                        //new RectHV()

                        double xmin = node.rectHV.xmin();
                        double ymin = node.rectHV.ymin();
                        double xmax = node.rectHV.xmax();
                        double ymax = node.point.y();

                        area = new RectHV(xmin, ymin, xmax, ymax);
                    }

                    if (area == null) {
                        area = node.left.rectHV;
                    }

                    node.left = insert(node.left, area, newPoint, node.level);
                } else {
                    RectHV area = null;
                    if (node.right == null) {
                        // calculate half-right
                        //new RectHV()

                        double xmin = node.rectHV.xmin();
                        double ymin = node.point.y();
                        double xmax = node.rectHV.xmax();
                        double ymax = node.rectHV.ymax();

                        area = new RectHV(xmin, ymin, xmax, ymax);

                    }

                    if (area == null) {
                        area = node.right.rectHV;
                    }


                    node.right = insert(node.right, area, newPoint, node.level);
                }
            }
        } else {
            // node null

            node = new Node(newPoint, rectHV, prevLevel + 1);
        }

        return node;
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if(p == null ) throw new IllegalArgumentException("parameter cannot be null");
        return search(p, root);
    }

    private boolean search(Point2D point, Node node) {
        if (node == null) {
            return false;
        }

        if (point.equals(node.point)) {
            return true;
        }

        if (node.isX()) {
            if (point.x() < node.point.x()) {
                return search(point, node.left);
            } else {
                return search(point, node.right);
            }
        } else {
            if (point.y() < node.point.y()) {
                return search(point, node.left);
            } else {
                return search(point, node.right);
            }
        }

    }

    // draw all points to standard draw
    public void draw() {
        StdDraw.rectangle(0, 0, 1, 1);

        draw(root);

    }

    private void draw(Node node) {
        if (node == null) {
            return;
        }
        StdDraw.rectangle(0, 0, 1, 1);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);

        node.point.draw();


        if (node.isX()) {
            StdDraw.setPenRadius(0.001);
            StdDraw.setPenColor(StdDraw.RED);

            Point2D top = new Point2D(node.point.x(), node.rectHV.ymax());
            Point2D bottom = new Point2D(node.point.x(), node.rectHV.ymin());
            top.drawTo(bottom);


            debugDrawing(top, bottom);

        } else {
            StdDraw.setPenRadius(0.001);
            StdDraw.setPenColor(StdDraw.BLUE);

            Point2D right = new Point2D(node.rectHV.xmin(), node.point.y());
            Point2D left = new Point2D(node.rectHV.xmax(), node.point.y());
            left.drawTo(right);

            debugDrawing(right, left);
        }


        draw(node.left);
        draw(node.right);

    }

    private void debugDrawing(Point2D nodeA, Point2D nodeB) {
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.setPenRadius(0.01);
        nodeA.draw();
        nodeB.draw();
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if(rect == null ) throw new IllegalArgumentException("parameter cannot be null");
        List<Point2D> points = new ArrayList<>();
        range(rect, root, points);
        return points;
    }


    private void range(RectHV query, Node node, List<Point2D> pointsMatched) {

        if (node == null) {
            return;
        }

        if (query.intersects(node.rectHV)) {

            if (query.contains(node.point)) {
                pointsMatched.add(node.point);
            }

            range(query, node.right, pointsMatched);
            range(query, node.left, pointsMatched);
        }


    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if(p == null ) throw new IllegalArgumentException("parameter cannot be null");
        return nearestRec(p, root, root.point);

    }

    /**
     * Nearest-neighbor search. To find a closest point to a given query point, start at the root and recursively search
     * in both subtrees using the following pruning rule: if the closest point discovered so far is closer than the
     * distance between the query point and the rectangle corresponding to a node, there is no need to explore that
     * node (or its subtrees). That is, search a node only only if it might contain a point that is closer than the best
     * one found so far. The effectiveness of the pruning rule depends on quickly finding a nearby point. To do this,
     * organize the recursive method so that when there are two possible subtrees to go down, you always choose the
     * subtree that is on the same side of the splitting line as the query point as the first subtree to explore—the
     * closest point found while exploring the first subtree may enable pruning of the second subtree.
     */
    private Point2D nearestRec(Point2D queryPoint, Node navigationNode, Point2D closerPoint) {
        if (navigationNode == null) {
            return closerPoint;
        }

        double distanceCloser         = queryPoint.distanceSquaredTo(closerPoint);
        double distanceNavigationNode = queryPoint.distanceSquaredTo(navigationNode.point);


        double min = distanceCloser;
        Point2D nearestPoint = closerPoint;

        if(distanceNavigationNode < distanceCloser) {
            min = distanceNavigationNode;
            nearestPoint = navigationNode.point;
        }


        if(navigationNode.left != null) {
            nearestPoint = nearestRec(queryPoint, navigationNode.left, nearestPoint);
        }


        if(navigationNode.right != null) {
            nearestPoint = nearestRec(queryPoint, navigationNode.right, nearestPoint);
        }

        return nearestPoint;

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

        Point2D queryPoint = new Point2D(0.489D, 0.992D);

        Point2D nearest = kdTree.nearest(queryPoint);

    }


}
