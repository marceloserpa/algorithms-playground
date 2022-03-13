import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class KdTreeTest {

    @Test
    @DisplayName("* 20 random non-degenerate points in a 32-by-32 grid")
    void testUseCase30() {
        KdTree kdTree = new KdTree();
        kdTree.insert(new Point2D(0.15625D, 0.875D));
        kdTree.insert(new Point2D(0.21875D, 0.375));
        kdTree.insert(new Point2D(0.375D, 0.03125));
        kdTree.insert(new Point2D(0.90625D, 0.65625));
        kdTree.insert(new Point2D(0.59375D, 0.5));
        kdTree.insert(new Point2D(0.9375D, 0.53125));
        kdTree.insert(new Point2D(0.625D, 0.25));
        kdTree.insert(new Point2D(0.125D, 0.90625));
        kdTree.insert(new Point2D(1.0D, 0.8125));
        kdTree.insert(new Point2D(0.09375D, 0.625));
        kdTree.insert(new Point2D(0.6875D, 0.40625));
        kdTree.insert(new Point2D(0.78125D, 0.21875));
        kdTree.insert(new Point2D(0.4375D, 1.0D));
        kdTree.insert(new Point2D(0.28125D, 0.75D));
        kdTree.insert(new Point2D(0.84375D, 0.4375D));
        kdTree.insert(new Point2D(0.75D, 0.71875D));
        kdTree.insert(new Point2D(0.71875D, 0.96875D));
        kdTree.insert(new Point2D(0.0D, 0.34375D));
        kdTree.insert(new Point2D(0.8125D, 0.9375D));
        kdTree.insert(new Point2D(0.875D, 0.125D));

        Point2D queryPoint = new Point2D(0.125D, 0.90625D);

        Assertions.assertTrue(kdTree.contains(queryPoint));

    }

    @Test
    public void sizeTest() {
        KdTree kd = new KdTree();
        kd.insert(new Point2D(0.25D, 0.5D));
        kd.insert(new Point2D(0.75D, 0.25D));
        kd.insert(new Point2D(0.75D, 0.75D));
        kd.insert(new Point2D(0.25D, 0.5D));

        Assertions.assertFalse(kd.isEmpty());
        Assertions.assertEquals(3, kd.size());
    }

    @Test
    public void sizeTest2() {
        KdTree kd = new KdTree();
        kd.insert(new Point2D(0.5D, 0.5D));

        Assertions.assertFalse(kd.isEmpty());
        Assertions.assertEquals(1, kd.size());
    }

    @Test
    public void queryTest() {
        KdTree kdTree = new KdTree();
        kdTree.insert(new Point2D(0.7D, 0.2D));
        kdTree.insert(new Point2D(0.5D, 0.4D));
        kdTree.insert(new Point2D(0.2D, 0.3D));
        kdTree.insert(new Point2D(0.4D, 0.7D));
        kdTree.insert(new Point2D(0.9D, 0.6D));

        Point2D queryPoint = new Point2D(0.5D, 0.4D);

        Assertions.assertTrue(kdTree.contains(queryPoint));
    }

    @Test
    public void queryInvalidPointTest() {
        KdTree kdTree = new KdTree();
        kdTree.insert(new Point2D(0.7D, 0.2D));
        kdTree.insert(new Point2D(0.5D, 0.4D));
        kdTree.insert(new Point2D(0.2D, 0.3D));
        kdTree.insert(new Point2D(0.4D, 0.7D));
        kdTree.insert(new Point2D(0.9D, 0.6D));

        Point2D queryPoint = new Point2D(0.5D, 0.88D);

        Assertions.assertFalse(kdTree.contains(queryPoint));
    }

    @Test
    public void queryTest2() {
        KdTree kdTree = new KdTree();
        kdTree.insert(new Point2D(1D, 0D));

        Point2D queryPoint = new Point2D(1D, 0D);

        Assertions.assertTrue(kdTree.contains(queryPoint));
    }

    @Test
    public void rangeTest1() {
        KdTree kdTree = new KdTree();
        kdTree.insert(new Point2D(0.372D, 0.497D));
        kdTree.insert(new Point2D(0.564D, 0.413D));
        kdTree.insert(new Point2D(0.226D, 0.577D));
        kdTree.insert(new Point2D(0.144D, 0.179D));
        kdTree.insert(new Point2D(0.083D, 0.51D));
        kdTree.insert(new Point2D(0.32D, 0.708D));
        kdTree.insert(new Point2D(0.417D, 0.362D));
        kdTree.insert(new Point2D(0.862D, 0.825D));
        kdTree.insert(new Point2D(0.785D, 0.725D));
        kdTree.insert(new Point2D(0.499D, 0.208D));

        RectHV rectangleQuery = new RectHV(0.222D, 0.208D,0.551D, 0.844D);

        Set<String> points = new HashSet<>();
        Iterable<Point2D> pointsFound = kdTree.range(rectangleQuery);
        for (Point2D point2D : pointsFound) {
            points.add(point2D.toString());
        }

        Point2D a = new Point2D(0.372D, 0.497D);
        Point2D c = new Point2D(0.226D, 0.577D);
        Point2D f = new Point2D(0.32D, 0.708D);
        Point2D g = new Point2D(0.417D, 0.362D);
        Point2D j = new Point2D(0.499D, 0.208D);


        Assertions.assertTrue(points.contains(a.toString()));
        Assertions.assertTrue(points.contains(c.toString()));
        Assertions.assertTrue(points.contains(f.toString()));
        Assertions.assertTrue(points.contains(g.toString()));
        Assertions.assertTrue(points.contains(j.toString()));
    }

    @DisplayName(" insert non-degenerate points; check range() with random query rectangles")
    @Test
    public void rangeTest2(){
        KdTree kdTree = new KdTree();
        kdTree.insert(new Point2D( 0.0D, 0.75D));
        kdTree.insert(new Point2D( 1.0D, 0.375D));
        kdTree.insert(new Point2D( 0.625D, 0.5D));
        kdTree.insert(new Point2D( 0.75D, 0.0D));
        kdTree.insert(new Point2D( 0.5D, 1.0D));

        RectHV rectangleQuery = new RectHV(0.125D, 0.625D,0.25D,  0.875D);


        Iterable<Point2D> pointsFound = kdTree.range(rectangleQuery);

        Assertions.assertFalse(pointsFound.iterator().hasNext());
    }



    @DisplayName("query rectangle = [0.3125, 0.75] x [0.3125, 0.5625]")
    @Test
    public void rangeTest3() {
        KdTree kdTree = new KdTree();
        kdTree.insert(new Point2D(0.1875D, 0.25D));
        kdTree.insert(new Point2D( 0.625D, 0.375D));
        kdTree.insert(new Point2D(0.6875D, 0.5D));
        kdTree.insert(new Point2D(0.8125D, 0.0D));
        kdTree.insert(new Point2D(0.9375D, 0.6875D));
        kdTree.insert(new Point2D( 0.0625D, 0.0625D));
        kdTree.insert(new Point2D(1.0D, 0.75D));
        kdTree.insert(new Point2D(0.0D, 0.9375D));
        kdTree.insert(new Point2D( 0.125D, 0.1875D));
        kdTree.insert(new Point2D(0.5625D, 1.0D));

        RectHV rectangleQuery = new RectHV(0.3125D, 0.3125D,0.75D, 0.5625D);

        Set<String> points = new HashSet<>();
        Iterable<Point2D> pointsFound = kdTree.range(rectangleQuery);
        for (Point2D point2D : pointsFound) {
            points.add(point2D.toString());
        }

        Point2D expectedB = new Point2D( 0.625D, 0.375D);
        Point2D expPointC = new Point2D(0.6875D, 0.5D);

        Assertions.assertTrue(points.contains(expectedB.toString()));
        Assertions.assertTrue(points.contains(expPointC.toString()));
    }



}