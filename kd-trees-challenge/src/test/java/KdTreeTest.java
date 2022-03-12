import edu.princeton.cs.algs4.Point2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KdTreeTest {

    @Test
    @DisplayName("* 20 random non-degenerate points in a 32-by-32 grid")
    void testUseCase30(){
        KdTree kdTree = new KdTree();
        kdTree.insert(new Point2D(0.15625D, 0.875D));
        kdTree.insert(new Point2D(0.21875D, 0.375));
        kdTree.insert(new Point2D(0.375D, 0.03125));
        kdTree.insert(new Point2D(0.90625D, 0.65625));
        kdTree.insert(new Point2D(0.59375D, 0.5));
        kdTree.insert(new Point2D(0.9375D, 0.53125));
        kdTree.insert(new Point2D(  0.625D, 0.25));
        kdTree.insert(new Point2D(  0.125D, 0.90625));
        kdTree.insert(new Point2D(  1.0D, 0.8125));
        kdTree.insert(new Point2D(  0.09375D, 0.625));
        kdTree.insert(new Point2D(0.6875D, 0.40625));
        kdTree.insert(new Point2D(0.78125D, 0.21875));
        kdTree.insert(new Point2D(0.4375D, 1.0D));
        kdTree.insert(new Point2D(0.28125D, 0.75D));
        kdTree.insert(new Point2D( 0.84375D,0.4375D));
        kdTree.insert(new Point2D( 0.75D, 0.71875D));
        kdTree.insert(new Point2D( 0.71875D, 0.96875D));
        kdTree.insert(new Point2D( 0.0D, 0.34375D));
        kdTree.insert(new Point2D( 0.8125D, 0.9375D));
        kdTree.insert(new Point2D( 0.875D, 0.125D));

        Point2D queryPoint = new Point2D(0.125D, 0.90625D);

        Assertions.assertTrue(kdTree.contains(queryPoint));

        /**
         *
         * 20 random non-degenerate points in a 32-by-32 grid
         - failed on trial 145 of 10000
         - query point          = (0.125, 0.90625)
         - student   contains() = false
         - reference contains() = true
         - sequence of points inserted:
         A  0.15625 0.875
         B  0.21875 0.375
         C  0.375 0.03125
         D  0.90625 0.65625
         E  0.59375 0.5
         F  0.9375 0.53125
         G  0.625 0.25
         H  0.125 0.90625
         I  1.0 0.8125
         J  0.09375 0.625
         K  0.6875 0.40625
         L  0.78125 0.21875
         M  0.4375 1.0
         N  0.28125 0.75
         O  0.84375 0.4375
         P  0.75 0.71875
         Q  0.71875 0.96875
         R  0.0 0.34375
         S  0.8125 0.9375
         T  0.875 0.125
         */

    }

}