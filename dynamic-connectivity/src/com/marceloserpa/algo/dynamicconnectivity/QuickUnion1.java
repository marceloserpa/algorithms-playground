package com.marceloserpa.algo.dynamicconnectivity;

public class QuickUnion1 {

	private int[] id;

	public QuickUnion1(int n) {
		id = new int[n];
		for(int i=0; i < n; i++) {
			id[i] = i;
		}
	}
	
	private int root(int i) {
		while(i != id[i]) i = id[i];
		return i;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
	
	public static void main(String[] args) {
		QuickUnion1 quickUnion = new QuickUnion1(10);
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
