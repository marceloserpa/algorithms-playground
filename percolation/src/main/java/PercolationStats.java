import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final static double BASE_CONFIDENCE_THRESHOLD = 1.96D;
    private double[] experimentResults;
    private final int experiments;


    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if(n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Arguments are not valid.");
        }

        this.experiments = trials;
        experimentResults = new double[this.experiments];
        int totalSites = n * n;

        for(int i = 0; i < trials; i++){
            Percolation percolation = new Percolation(n);
            while(percolation.percolates() == false) {
                int x = StdRandom.uniform(1, n + 1);
                int y = StdRandom.uniform(1, n + 1);

                //StdOut.println("# " + i + " Open site: row = " + x + "col = " + y);
                percolation.open(x, y);
            }

            //  204/400 = 0.51
            double result = (double) percolation.numberOfOpenSites() / totalSites;
            //StdOut.println("#" + i + " = (" + percolation.numberOfOpenSites() + " / " + totalSites + ") -> " +result);
            experimentResults[i] = result;
        }


    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(experimentResults);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(experimentResults);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (BASE_CONFIDENCE_THRESHOLD / Math.sqrt(this.experiments));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (BASE_CONFIDENCE_THRESHOLD / Math.sqrt(this.experiments));
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats ps = new PercolationStats(10, 1);

        String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }

}