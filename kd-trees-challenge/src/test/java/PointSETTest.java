import edu.princeton.cs.algs4.Point2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointSETTest {

    @Test
    public void nearestTest(){
        PointSET pointSET = new PointSET();
        pointSET.insert(new Point2D(1.0D, 1.0D));
        pointSET.insert(new Point2D(0.0D, 0.25D));
        pointSET.insert(new Point2D(0.25D, 0.0D));
        pointSET.insert(new Point2D(1.0D, 0.5D));
        pointSET.insert(new Point2D(0.75D, 0.0D));
        pointSET.insert(new Point2D(0.75D, 0.25D));
        pointSET.insert(new Point2D(0.5D, 0.75D));
        pointSET.insert(new Point2D(1.0D, 1.0D));
        pointSET.insert(new Point2D(0.25D, 0.5D));
        pointSET.insert(new Point2D(1.0D, 0.5D));

        Point2D query = new Point2D(0.5D, 0.75D);
        Point2D nearest = pointSET.nearest(query);

        Assertions.assertEquals(0.5D, nearest.x());
        Assertions.assertEquals(0.75D, nearest.y());
        Assertions.assertEquals(0, query.distanceSquaredTo(nearest));
    }

    @Test
    public void shouldThrownException(){
        PointSET pointSET = new PointSET();

        Assertions.assertThrows(IllegalArgumentException.class, () -> pointSET.insert(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> pointSET.contains(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> pointSET.range(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> pointSET.nearest(null));
    }

    @DisplayName("Test 3: insert random points; check nearest() with random query points\n" +
            "  * 10 random points in a 4-by-4 grid")
    @Test
    public void caseTest3(){
        PointSET pointSET = new PointSET();
        pointSET.insert(new Point2D(1.0D, 1.0D));
        pointSET.insert(new Point2D(0.25D, 0.75D));
        pointSET.insert(new Point2D(0.5D, 0.25D));
        pointSET.insert(new Point2D(0.75D, 0.25D));
        pointSET.insert(new Point2D(0.75D, 1.0D));
        pointSET.insert(new Point2D( 0.5D, 1.0D));
        pointSET.insert(new Point2D(1.0D, 0.0D));
        pointSET.insert(new Point2D(1.0D, 0.75D));
        pointSET.insert(new Point2D(0.5D, 0.25D));
        pointSET.insert(new Point2D(0.25D, 0.25D));

        Point2D queryPoint = new Point2D(0.5D,0.75D);
        Point2D nearest = pointSET.nearest(queryPoint);

        Assertions.assertEquals(0.25D, nearest.x());
        Assertions.assertEquals(0.75D, nearest.y());

        Assertions.assertEquals(0.0625D, queryPoint.distanceSquaredTo(nearest));
    }

}