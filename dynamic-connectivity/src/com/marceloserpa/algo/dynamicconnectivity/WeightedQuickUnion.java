package com.marceloserpa.algo.dynamicconnectivity;


// Weighted algo is used to avoid create tall tree
public class WeightedQuickUnion {

	private int[] id;
	private int[] sz; // array created to keep size of tree

	public WeightedQuickUnion(int n) {
		id = new int[n];
		sz = new int[n];
		for(int i=0; i < n; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	private int root(int i) {
		while(i != id[i]) {
			// Path compression
			id[i] = id[id[i]]; 
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		
		// Link root of smaller three to root of larger tree
		// Update the sz[] array
		if(i == j) return;
		if(sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}
	
	public int[] getIds() {
		return id;
	}
	
	public static void main(String[] args) {
		WeightedQuickUnion quickUnion = new WeightedQuickUnion(10);
		quickUnion.union(4, 3);
		quickUnion.union(3, 8);
		quickUnion.union(6, 5);
		quickUnion.union(9, 4);
		quickUnion.union(2, 1);
		System.out.println(String.format("8 is connect on 9 = %s", quickUnion.connected(8, 9)));
		System.out.println(String.format("5 is connect on 0 = %s", quickUnion.connected(5, 0)));
		
		quickUnion.union(5, 0);
		System.out.println(String.format("5 is connect on 0 = %s", quickUnion.connected(5, 0)));
		
	}
	
}
