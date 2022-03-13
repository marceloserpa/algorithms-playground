import edu.princeton.cs.algs4.Point2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}