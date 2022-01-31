import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF dynamicConnection;
    private WeightedQuickUnionUF dynamicConnectionFull;

    private int matrixSize;
    private  int totalOpenSites = 0;
    private boolean[] openSites;

    private int virtualTop;
    private int virtualBottom;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if(n < 1) {
            throw new IllegalArgumentException("n should be > 0");
        }
        matrixSize = n;
        int sites = n * n;
        dynamicConnection = new WeightedQuickUnionUF(sites + 2);
        dynamicConnectionFull = new WeightedQuickUnionUF(sites + 1); // connects only in the top virtual node
        openSites = new boolean[sites];

        // creating virtual nodes
        virtualTop = sites;
        virtualBottom = sites + 1;

        // connect top nodes with head
        for(int i =0; i < n; i++) {
            StdOut.println("Connect to virtual top: " + i);
            dynamicConnection.union(virtualTop, i);
            dynamicConnectionFull.union(virtualTop, i);
        }

        // connect bottoms nodes with bottom
        int bottom = (n * n ) - n;
        if(bottom < 0) bottom = 0;
        for(int i = bottom; i < sites; i++) {
            StdOut.println("Connect to virtual bottom: " + i);
            dynamicConnection.union(virtualBottom, i);
        }

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);

        if(isOpen(row, col)) return;

        int siteIndex = calculateIndex(row, col);
        openSites[siteIndex] = true;
        totalOpenSites++;
        StdOut.println(String.format("Opened site row=%d or col=%d", row, col));
        render();

        // try connect with other 4 neighbors (left, right, top, bottom) if open

        // connect to top neighbor
        if(row > 1) {
            int topNeighbor = calculateIndex(row -1, col);
            if(topNeighbor >= 0 && openSites[topNeighbor]) {
                dynamicConnection.union(siteIndex, topNeighbor);
                dynamicConnectionFull.union(siteIndex, topNeighbor);
                StdOut.println(String.format("Connected site row=%d or col=%d with top neighbor", row, col));
            }
        }

        // connect to bottom neighbor
        if(row < matrixSize) {
            int bottomNeighbor = calculateIndex(row + 1, col);
            if(bottomNeighbor < (virtualBottom - 1) && openSites[bottomNeighbor]) {
                dynamicConnection.union(siteIndex, bottomNeighbor);
                dynamicConnectionFull.union(siteIndex, bottomNeighbor);
                StdOut.println(String.format("Connected site row=%d or col=%d with bottom neighbor", row, col));
            }
        }

        // connect to left neighbor
        if(col > 1) {
            int leftNeighbor = calculateIndex(row, col - 1);
            if(leftNeighbor >= 0 && openSites[leftNeighbor]) {
                dynamicConnection.union(siteIndex, leftNeighbor);
                dynamicConnectionFull.union(siteIndex, leftNeighbor);
                StdOut.println(String.format("Connected site row=%d or col=%d with left neighbor", row, col));
            }
        }

        // connect to right neighbor
        if(col < matrixSize) {
            int rightNeighbor = calculateIndex(row, col + 1);
            if(rightNeighbor <= matrixSize * matrixSize - 1 && openSites[rightNeighbor]) {
                dynamicConnection.union(siteIndex, rightNeighbor);
                dynamicConnectionFull.union(siteIndex, rightNeighbor);
                StdOut.println(String.format("Connected site row=%d or col=%d with right neighbor", row, col));
            }
        }

        StdOut.println(String.format("Completed site row=%d or col=%d\n\n", row, col));
    }

    private int calculateIndex(int row, int col) {
        return (matrixSize * (row - 1 )) + (col - 1);
    }


    // returns the number of open sites
    public int numberOfOpenSites(){
        return totalOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        render();
        return dynamicConnection.connected(virtualTop, virtualBottom);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        validate(row, col);
        int siteIndex = calculateIndex(row, col);
        return openSites[siteIndex];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row, col);
        int siteIndex = calculateIndex(row, col);
        return openSites[siteIndex] && dynamicConnectionFull.connected(siteIndex, virtualTop);
    }

    private void render() {
        int columnIndex = 1;
        boolean[] sites = openSites;
        for(int i = 0; i < sites.length; i++) {
            StdOut.print(" " + ( openSites[i] ? "x" : "-") + " ");
            if(columnIndex == matrixSize) {
                StdOut.println("");
                columnIndex = 1;
            } else {
                columnIndex++;
            }
        }

    }

    private void validate(int row, int col){
        if(row <= 0 || col <= 0 || row > matrixSize || col > matrixSize) {
            throw new IllegalArgumentException("invalid parameters");
        }
    }

    // test client (optional)
    public static void main(String[] args) {

    }

}
