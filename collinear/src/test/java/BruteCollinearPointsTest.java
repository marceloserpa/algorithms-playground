import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class BruteCollinearPointsTest {


    @Test
    public void shouldThrowsIllegalArgumentExceptionIfReceiveDuplicatedPoints() {
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
    public void shouldReturnSegments() {
        Point p = new Point(10000, 0);

        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(new Point[]{p});
        Assertions.assertEquals(1, bruteCollinearPoints.segments());
    }

    @Test
    public void equidistant() {
        List<Point> points = new ArrayList<>();
        Point p1 = new Point(10000, 0);
        Point p2 = new Point(8000, 2000);
        Point p3 = new Point(2000, 8000);
        Point p4 = new Point(0, 10000);

        Point p5 = new Point(20000, 0);
        Point p6 = new Point(18000, 2000);
        Point p7 = new Point(2000, 18000);

        Point p8 = new Point(10000, 20000);
        Point p9 = new Point(30000, 0);
        Point p10 = new Point(0, 30000);
        Point p11 = new Point(20000, 10000);

        Point p12 = new Point(13000, 0);
        Point p13 = new Point(11000, 3000);
        Point p14 = new Point(5000, 12000);
        Point p15 = new Point(9000, 6000);
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
        points.add(p5);
        points.add(p6);
        points.add(p7);
        points.add(p8);
        points.add(p9);
        points.add(p10);
        points.add(p11);
        points.add(p12);
        points.add(p13);
        points.add(p14);
        points.add(p15);


        Point[] pointsFinal = points.toArray(new Point[]{});


        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(pointsFinal);

        LineSegment[] segments = bruteCollinearPoints.segments();

        HashSet<String> distinctLineSegments = new HashSet<>();
        for(LineSegment lineSegment : segments) {
            distinctLineSegments.add(lineSegment.toString());
        }

        Assertions.assertEquals(distinctLineSegments.size(), segments.length);
    }

}