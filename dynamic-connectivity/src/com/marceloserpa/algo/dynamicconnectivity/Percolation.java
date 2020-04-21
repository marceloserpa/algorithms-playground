package com.marceloserpa.algo.dynamicconnectivity;

public class Percolation {
	
	private WeightedQuickUnion dynamicConnection;
	
	private int matrixSize;
	private boolean[] openSites;
	
	private int virtualTop;
	private int virtualBottom;
	
	
	public Percolation(int n) {
		matrixSize = n;
		int sites = n * n;
		dynamicConnection = new WeightedQuickUnion(sites + 2);
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
	
	public void open(int row, int col) {
		if(row >= matrixSize || col >= matrixSize) {
			System.out.println("Cannot open site row="+ row +" or col="+col + " invalid position");
			return;
		}
		int siteIndex = (row * matrixSize)+ col;
		openSites[siteIndex] = true;
		
		// try connect with other 4 neighbors (left, right, top, bottom) if open
		
		// connect to top neighbor
		int topNeighbor = siteIndex - matrixSize;
		if(topNeighbor > 0 && openSites[topNeighbor]) {
			dynamicConnection.union(siteIndex, topNeighbor);
		}
		
		// connect to bottom neighbor
		int bottomNeighbor = siteIndex + matrixSize;
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
	
	public boolean percolate() {
		return dynamicConnection.connected(virtualTop, virtualBottom);
	}

	public void render() {
		System.out.println("Percolation: ");
		int columnIndex = 1;
		int[] sites = dynamicConnection.getIds();
		for(int i = 0; i < sites.length-2; i++) {
			//System.out.print(" " + ( openSites[i] ? "[" + i + "]" : "(" + i + ")") + " ");
			System.out.print(" " + ( openSites[i] ? "x" : "-") + " ");
			if(columnIndex == matrixSize) {
				System.out.println("");	
				columnIndex = 1;	
			} else {
				columnIndex++;
			}
		}	
		
		System.out.println("Percolate: " + percolate());
	}	
	
	public static void main(String[] args) {
		Percolation percolation = new Percolation(5);		
		percolation.open(0, 3);
		percolation.open(1, 3);
		percolation.open(2, 3);
		percolation.open(2, 2);
		percolation.open(3, 2);
		percolation.open(4, 2);

		percolation.open(0, 5);
		percolation.render();
		
	}
}
