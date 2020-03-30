package com.marceloserpa.algo.dynamicconnectivity;

public class QuickFind {

	private int[] id;

	// N array access
	public QuickFind(int n) {
		this.id = new int[n];
		
		for(int i=0; i<n; i++) {
			id[i] = i; 
		}
	}
	
	// 2 array access
	public boolean connected(int p, int q) {
		return id[p] == id[q]; 
	}
	
	// 2N + 2 array access
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		
		for(int i = 0; i < id.length; i++) {
			if(id[i] == pid) {
				id[i] = qid;
			}
		}
		
		/**
		 * Too much expensive
		 * Takes N² array access to process sequence of N union commands on N objects 
		 */
		
	}

	
	public static void main(String[] args) {
		QuickFind quickFind = new QuickFind(10);
		quickFind.union(4, 3);
		quickFind.union(3, 8);
		quickFind.union(6, 5);
		quickFind.union(9, 4);
		quickFind.union(2, 1);
		System.out.println(String.format("8 is connect on 9 = %s", quickFind.connected(8, 9)));
		System.out.println(String.format("5 is connect on 0 = %s", quickFind.connected(5, 0)));
		
		quickFind.union(5, 0);
		System.out.println(String.format("5 is connect on 0 = %s", quickFind.connected(5, 0)));
		
	}
	
}
