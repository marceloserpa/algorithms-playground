import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationOld {

    private WeightedQuickUnionUF dynamicConnection;

    private int matrixSize;
    private  int totalOpenSites = 0;
    private boolean[] openSites;

    private int virtualTop;
    private int virtualBottom;

    // creates n-by-n grid, with all sites initially blocked
    public PercolationOld(int n) {
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
    public void open(int paramRow, int paramCol) {
        int row = paramRow-1;
        int col = paramCol-1;

        if(row >= matrixSize || col >= matrixSize) {
           // System.out.println("Cannot open site row="+ row +" or col="+col + " invalid position");
            return;
        }
        int siteIndex = (row * matrixSize) + col;
      //  System.out.println("siteIndex = (" + row + " * " + matrixSize + " ) + " + col + " = "  + siteIndex);
        if(!isOpen(row, col)) {
            openSites[siteIndex] = true;
            totalOpenSites++;
        }
        // try connect with other 4 neighbors (left, right, top, bottom) if open

        // connect to top neighbor
        int topNeighbor = siteIndex - matrixSize;
        if(topNeighbor > 0 && openSites[topNeighbor]) {
            dynamicConnection.union(siteIndex, topNeighbor);
        }

        // connect to bottom neighbor
        int bottomNeighbor = siteIndex + matrixSize;
        if(bottomNeighbor >= matrixSize * matrixSize){
            bottomNeighbor = (matrixSize * matrixSize)- 1;
        }
        if(bottomNeighbor < virtualBottom && openSites[bottomNeighbor]) {
            dynamicConnection.union(siteIndex, bottomNeighbor);
        }

        // connect to left neighbor
        int leftNeighbor = siteIndex - 1;
        if(row > 0 && openSites[leftNeighbor]) {
            dynamicConnection.union(siteIndex, leftNeighbor);
        }

        // connect to right neighbor
        int rightNeighbor = siteIndex + 1;
        if(col < (matrixSize - 1) && openSites[rightNeighbor]) {
            dynamicConnection.union(siteIndex, rightNeighbor);
        }

    }

    private int calculateIndex(int row, int col) {
        return matrixSize * (row - 1 ) + col;
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
        int siteIndex = (row * matrixSize)+ col;
        if(siteIndex >= matrixSize * matrixSize){
            siteIndex = (matrixSize * matrixSize)- 1;
        }
       // int siteIndex = calculateIndex(row, col);
        return openSites[siteIndex];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return true;
    }

    private void render() {
        System.out.println("Percolation: ");
        int columnIndex = 1;
        boolean[] sites = openSites;
        for(int i = 0; i < sites.length; i++) {
            //System.out.print(" " + ( openSites[i] ? "[" + i + "]" : "(" + i + ")") + " ");
            System.out.print(" " + ( openSites[i] ? "x" : "-") + " ");
            if(columnIndex == matrixSize) {
                System.out.println("");
                columnIndex = 1;
            } else {
                columnIndex++;
            }
        }

        System.out.println("\n\n\n");
        System.out.println("Percolate: " + percolates());
    }

    // test client (optional)
    public static void main(String[] args) {
        PercolationOld percolation = new PercolationOld(5);
        percolation.open(1, 4);
        percolation.open(2, 4);
        percolation.open(3, 4);
        percolation.open(4, 4);
        percolation.open(4, 4);
        percolation.open(5, 4);

        percolation.render();
       // System.out.println(percolation.percolates());

    }

}
