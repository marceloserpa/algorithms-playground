package com.marceloserpa.algo.disjointsetunion;

public class DSUNaiveImpl {

    private final int[] parent;

    public DSUNaiveImpl(int size){
        parent = new int[size+1]; // index+1

        for(int i = 1; i <= size; i++){
            parent[i] = i;
        }

    }

    public boolean connect(int i, int j){
        return find(i) == find(j);
    }

    public int find(int i){
        if(i == parent[i]) return i;
        return find(parent[i]);
    }

    public void union(int i, int j){
        int parentI = find(i);
        int parentJ = find(j);
        if(parentI != parentJ) {
            parent[parentJ] = parentI;
        }
    }

    public void print(){
        for(int i = 1; i < parent.length; i++) {
            System.out.println(i + " -> " + parent[i]);
        }
    }

}
