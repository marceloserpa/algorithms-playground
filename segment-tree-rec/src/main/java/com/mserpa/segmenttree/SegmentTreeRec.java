package com.mserpa.segmenttree;

public class SegmentTreeRec {

    private int [] numbers;
    private int size;
    private int [] tree;

    public SegmentTreeRec(int[] numbers) {
        this.size = numbers.length;
        this.numbers = numbers;
        this.tree = new int[size * 4];

        build(0, 0, size -1);
    }

    private void build(int parentNodeIndex, int lo, int hi){
        if(lo == hi) {
            tree[parentNodeIndex] = numbers[lo];
            return;
        }

        int mid = lo + (hi - lo) / 2;
        // calculate children nodes:  L =(2 * i +1) R=(2 * i +2)
        build(2 * parentNodeIndex + 1, lo, mid);
        build(2 * parentNodeIndex + 2, mid + 1, hi);

        // merge function (hardcoded max)
        tree[parentNodeIndex] = Math.max(tree[2 * parentNodeIndex + 1], tree[2 * parentNodeIndex + 2]);
    }

    public int query(int queryLeft, int queryRight){
        return query(0, 0, this.size -1, queryLeft, queryRight);
    }

    private int query(int parentTreeIndex, int lo, int hi, int queryLeft, int queryRight){
        if(lo > queryRight || hi < queryLeft) { // outside rangee
            return Integer.MIN_VALUE;
        }

        if(queryLeft <= lo && queryRight >= hi) {
            return tree[parentTreeIndex];
        }

        int mid = lo + (hi - lo) / 2;
        return Math.max(query(2 * parentTreeIndex + 1, lo, mid, queryLeft, queryRight), query(2 * parentTreeIndex + 2, mid +1 , hi, queryLeft, queryRight));
    }

}
