import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF dynamicConnection;

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
        openSites = new boolean[sites];

        // creating virtual nodes
        virtualTop = sites;
        virtualBottom = sites + 1;

        // connect top nodes with head
        for(int i =0; i < n; i++) {
            dynamicConnection.union(virtualTop, i);
        }

        // connect bottoms nodes with bottom
        int bottom = (n * n - 1) - n;
        for(int i = bottom; i < sites; i++) {
            dynamicConnection.union(virtualBottom, i);
        }

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if(row > matrixSize || col > matrixSize) {
            //StdOut.println("Cannot open site row="+ row +" or col="+col + " invalid position");
            return;
        }

        if(isOpen(row, col)) return;

        int siteIndex = calculateIndex(row, col);
        openSites[siteIndex] = true;
        totalOpenSites++;

        // try connect with other 4 neighbors (left, right, top, bottom) if open

        // connect to top neighbor
        int topNeighbor = calculateIndex(row -1, col);
        if(topNeighbor >= 0 && openSites[topNeighbor]) {
            dynamicConnection.union(siteIndex, topNeighbor);
        }

        // connect to bottom neighbor
        int bottomNeighbor = calculateIndex(row + 1, col);
        if(bottomNeighbor < (virtualBottom - 1) && openSites[bottomNeighbor]) {
            dynamicConnection.union(siteIndex, bottomNeighbor);
        }

        // connect to left neighbor
        int leftNeighbor = calculateIndex(row, col - 1);
        if(leftNeighbor >= 0 && openSites[leftNeighbor]) {
            dynamicConnection.union(siteIndex, leftNeighbor);
        }

        // connect to right neighbor
        int rightNeighbor = calculateIndex(row, col + 1);
        if(rightNeighbor <= matrixSize - 1 && openSites[rightNeighbor]) {
            dynamicConnection.union(siteIndex, rightNeighbor);
        }

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
        return dynamicConnection.connected(virtualTop, virtualBottom);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        int siteIndex = calculateIndex(row, col);
        return openSites[siteIndex];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int siteIndex = calculateIndex(row, col);
        return openSites[siteIndex] && dynamicConnection.connected(siteIndex, virtualTop);
    }

    private void render() {
        StdOut.println("Percolation: ");
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

    // test client (optional)
    public static void main(String[] args) {
        /**
        Percolation percolation = new Percolation(5);
        percolation.open(1, 4);
        percolation.open(2, 4);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(4, 3);
        percolation.open(4, 4);
        percolation.open(5, 4);

        percolation.render();
       // StdOut.println(percolation.percolates());
         **/



        Percolation percolation = new Percolation(2);
        //percolation.open(1, 3);
        //percolation.open(1, 1);


       // percolation.open(2,1);
        //percolation.open(1,1);

        percolation.render();

        StdOut.println("isOpen = " + percolation.isOpen(1,1));
        StdOut.println("full = " + percolation.isFull(1,1));
         StdOut.println("percolate = " + percolation.percolates());
    }

}
