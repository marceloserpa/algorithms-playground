import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

    /**
     * Brute force. Write a program BruteCollinearPoints.java that examines 4 points at a time and checks whether they
     * all lie on the same line segment, returning all such line segments. To check whether the 4 points p, q, r, and s are collinear,
     * check whether the three slopes between p and q, between p and r, and between p and s are all equal.
     *
     * The method segments() should include each line segment containing 4 points exactly once. If 4 points appear on a
     * line segment in the order p→q→r→s, then you should include either the line segment p→s or s→p (but not both) and
     * you should not include subsegments such as p→r or q→r. For simplicity, we will not supply any input to
     * BruteCollinearPoints that has 5 or more collinear points.
     *
     * Corner cases. Throw an IllegalArgumentException if the argument to the constructor is null, if any point in the
     * array is null, or if the argument to the constructor contains a repeated point.
     *
     * Performance requirement. The order of growth of the running time of your program should be n4 in the worst case
     * and it should use space proportional to n plus the number of line segments returned.
     * @param points
     */


    private LineSegment[] segments;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {

        segments = new LineSegment[0];

        // validate entries
        if(points == null) {
            throw new IllegalArgumentException("points cannot be null");
        }

        for(int i = 0; i < points.length; i++) {
            if(points[i] == null) {
                throw new IllegalArgumentException("point cannot be null");
            }
        }

        Point[] copy = Arrays.copyOf(points, points.length);
        Arrays.sort(copy);
        for (int i = 0; i < copy.length -1; i++){
            if(copy[i].compareTo(copy[i+1]) == 0) throw new IllegalArgumentException("points cannot have duplicated points");
        }

        /**
         * o check whether the 4 points p, q, r, and s are collinear,
         *      * check whether the three slopes between p and q, between p and r, and between p and s are all equal.
         */

        List<LineSegment> segmentsCollinears =  new ArrayList<>();

        // https://en.wikipedia.org/wiki/Combination

        // complexity O(n ^4)
        // n!/(n-4)
        for(int p = 0; p < points.length; p++) {
            for(int q = p+1; q < points.length; q++) {
                for(int r = p+2; r < points.length; r++) {
                    for(int s = p+3; s < points.length; s++) {
                        if(points[p].slopeTo(points[q]) == points[p].slopeTo(points[r])
                                && points[p].slopeTo(points[r]) == points[p].slopeTo(points[s])) {
                            segmentsCollinears.add(new LineSegment(points[p], points[s]));
                        }
                    }
                }
            }
        }

        segments = new LineSegment[segmentsCollinears.size()];
        int index = 0;
        for(LineSegment lineSegment : segmentsCollinears) {
            segments[0] = lineSegment;
            index++;
        }

    }

    // the number of line segments
    public int numberOfSegments()  {
        return segments.length;
    }

    // the line segments
    public LineSegment[] segments() {
        return segments;
    }

}
