import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

    private LineSegment[] segments;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        validateEntries(points);

        segments = new LineSegment[0];

        List<LineSegment> collinearSegments = new ArrayList<>();


        /**
        Point[] internalPoints = Arrays.copyOf(points, points.length);
        for (int p = 0; p < internalPoints.length - 1; p++) {
            Arrays.sort(internalPoints, internalPoints[p].slopeOrder());

            double latestSlope = internalPoints[p].slopeTo(internalPoints[p + 1]);

            List<Point> pointsFound = new ArrayList<>();
            pointsFound.add(internalPoints[p]);

            for (int q =  2; q < internalPoints.length; q++) {

                double slop = internalPoints[p].slopeTo(internalPoints[q]);
                if (Double.compare(latestSlope, slop) == 0) {
                    System.out.println("EQUALLLLL p = " + p + " q = " + q);
                    pointsFound.add(internalPoints[q]);
                } else {
                    System.out.println("break");
                    if(pointsFound.size() >= 3) {
                        pointsFound.sort(null);
                        Point begin = pointsFound.get(0);
                        Point end = pointsFound.get(pointsFound.size() - 1);
                        collinearSegments.add(new LineSegment(begin, end));
                    }

                    // cleanup
                    pointsFound = new ArrayList<>();
                    pointsFound.add(internalPoints[p]);
                }


            }
        }
         **/


        Point[] internalPoints = Arrays.copyOf(points, points.length);
        for (Point point : points) {
            Arrays.sort(internalPoints, point.slopeOrder());

            double latestSlope = point.slopeTo(internalPoints[1]);

            List<Point> pointsFound = new ArrayList<>();
            pointsFound.add(internalPoints[1]);

            for (int q = 1; q < internalPoints.length; q++) {

                double slop = point.slopeTo(internalPoints[q]);
                if (Double.compare(latestSlope, slop) == 0) {
                    //System.out.println("EQUALLLLL p = " + point + " q = " + q);
                    pointsFound.add(internalPoints[q]);
                } else {
                    //System.out.println("break");
                    if(pointsFound.size() >= 3) {
                        pointsFound.sort(null);
                        Point begin = pointsFound.get(0);
                        Point end = pointsFound.get(pointsFound.size() - 1);
                        collinearSegments.add(new LineSegment(begin, end));
                    }

                    // cleanup
                    pointsFound = new ArrayList<>();
                    pointsFound.add(point);
                }


            }
        }

        segments = collinearSegments.toArray(new LineSegment[]{});


    }

    private void validateEntries(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("points cannot be null");
        }

        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("point cannot be null");
            }
        }

        Point[] copyOfPoints = Arrays.copyOf(points, points.length);
        Arrays.sort(copyOfPoints);
        for (int i = 0; i < copyOfPoints.length - 1; i++) {
            if (copyOfPoints[i].compareTo(copyOfPoints[i + 1]) == 0)
                throw new IllegalArgumentException("points cannot have duplicated points");
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.length;
    }

    // the line segments
    public LineSegment[] segments() {
        return Arrays.copyOf(segments, segments.length);
    }
}