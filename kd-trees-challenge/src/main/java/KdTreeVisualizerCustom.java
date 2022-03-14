import edu.princeton.cs.algs4.*;

public class KdTreeVisualizerCustom {

    public static void main(String[] args) {

        KdTree kdtree = new KdTree();

        // initialize the data structures from file
        String filename = args[0];
        In in = new In(filename);

        while (!in.isEmpty()) {
            double x = Double.parseDouble(String.format("0.%d", in.readInt()));
            double y = Double.parseDouble(String.format("0.%d", in.readInt()));
            Point2D p = new Point2D(x, y);
            kdtree.insert(p);

            StdDraw.pause(1);
        }

        kdtree.draw();
        StdDraw.show();


        StdDraw.pause(20);

        /*
        RectHV rect = new RectHV(0.0, 0.0, 1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        while (true) {
            if (StdDraw.isMousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                StdOut.printf("%8.6f %8.6f\n", x, y);
                Point2D p = new Point2D(x, y);
                if (rect.contains(p)) {
                    StdOut.printf("%8.6f %8.6f\n", x, y);
                    kdtree.insert(p);
                    StdDraw.clear();
                    kdtree.draw();
                    StdDraw.show();
                }
            }
            StdDraw.pause(20);
        }

         */

    }
}