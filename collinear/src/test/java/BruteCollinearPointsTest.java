import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BruteCollinearPointsTest {


    @Test
    public void shouldThrowsIllegalArgumentExceptionIfReceiveDuplicatedPoints(){
        Point a = new Point(471, 439);
        Point b = new Point(474, 439);
        Point c = new Point(470, 439);
        Point d = new Point(471, 439);

        Point[] points = new Point[]{a, b, c, d};

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BruteCollinearPoints(points);
        });
    }

    @Test
    public void shouldReturnSegments(){
        Point p = new Point(10000, 0);

        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(new Point[]{p});
        Assertions.assertEquals(1, bruteCollinearPoints.segments());
    }

}